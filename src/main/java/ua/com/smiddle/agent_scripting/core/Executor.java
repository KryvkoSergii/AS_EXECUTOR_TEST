package ua.com.smiddle.agent_scripting.core;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.smiddle.agent_scripting.core.model.AdmGroup;
import ua.com.smiddle.agent_scripting.core.model.AdmRole;
import ua.com.smiddle.agent_scripting.core.model.AdmUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by srg on 27.06.16.
 */

public class Executor {
    static {
        System.out.println("starting executor...");
    }

    private final String password = "password";
    private final String roleName = "TEST-ROLE";
    private final String groupName = "TEST-GROUP";
    ThreadGroup threadGroup = new ThreadGroup("ThreadGroup");
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgentScripting");
    private EntityManager em = emf.createEntityManager();
    private Random random = new Random();
    private Map<String, AdmUser> users = new ConcurrentHashMap<>();
    //    private Map<String, AdmUser> initUsers = new ConcurrentHashMap<>();
    private Map<String, Unit> collection = new ConcurrentHashMap<>();
    private Query query;
    private PasswordEncoder pe = new BCryptPasswordEncoder(10);
    private String host;
    private int DEBUG_LEVEL = 0;
    private int userCount = 0;
    private volatile Long scriptID;


    //Getters and setters
    public ThreadGroup getThreadGroup() {
        return threadGroup;
    }

    public void setThreadGroup(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getDEBUG_LEVEL() {
        return DEBUG_LEVEL;
    }

    public void setDEBUG_LEVEL(int DEBUG_LEVEL) {
        this.DEBUG_LEVEL = DEBUG_LEVEL;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getScriptID() {
        return scriptID;
    }

    public void setScriptID(Long scriptID) {
        this.scriptID = scriptID;
    }


    //Methods
    private void initLoadingUsers() {
        em.getTransaction().begin();
        ArrayList<AdmUser> tmp = (ArrayList<AdmUser>) em.createQuery("SELECT u FROM AdmUser u where u.login like 'user-%' and u.deleted=false", AdmUser.class).getResultList();
        em.getTransaction().commit();
        for (AdmUser u : tmp) {
            users.put(u.getLogin(), u);
        }
        System.out.printf("Initial load users ... %s" + '\n', users.size());
    }

    //    проверка роли. Если роли с таким именем не сущетствует она быдет создана
    private List<AdmRole> checkRole(String roleName) {
        List<AdmRole> result = new ArrayList<>();
        em.getTransaction().begin();
        query = em.createQuery("SELECT r FROM AdmRole r where r.name=?1", AdmRole.class);
        query.setParameter(1, roleName);
        ArrayList<AdmRole> tmp = (ArrayList<AdmRole>) query.getResultList();
        em.getTransaction().commit();

        if (tmp.isEmpty()) {
            AdmRole testRole = new AdmRole();
            testRole.setName(roleName);
            em.getTransaction().begin();
            testRole = em.merge(testRole);
            em.getTransaction().commit();
            result.add(testRole);
        } else {
            for (AdmRole r : tmp) result.add(r);
        }
        return result;
    }

    //Проверка группы. Если группы с таким именем не сущетствует она быдет создана
    private List<AdmGroup> checkGroup(String groupName) {
        List<AdmGroup> result = new ArrayList<>();
        em.getTransaction().begin();
        query = em.createQuery("SELECT g FROM AdmGroup g where g.name=?1", AdmGroup.class);
        query.setParameter(1, groupName);
        List<AdmGroup> tmp = (ArrayList<AdmGroup>) query.getResultList();
        em.getTransaction().commit();
        if (tmp.isEmpty()) {
            AdmGroup group = new AdmGroup();
            group.setParent(null);
            group.setScripts(null);
            group.setUsers(null);
            group.setName(groupName);
            em.getTransaction().begin();
            group = em.merge(group);
            em.getTransaction().commit();
            result.add(group);
        } else {
            for (AdmGroup g : tmp) {
                result.add(g);
            }
        }
        return result;
    }

    //создание потоков
    public void prepare() {
        initLoadingUsers();
        List<AdmRole> role = checkRole(roleName);
        List<AdmGroup> groupList = checkGroup(groupName);
        // привести список пользователей к нужному размеру (удалить лишнее)
        if (users.size() > userCount) {
            Set<String> set = users.keySet();
            Iterator i = set.iterator();
            while (i.hasNext()) {
                users.remove(i.next());
                if ((users.size() == userCount)) break;
            }
        } else if (users.size() == userCount) {
        } else {
            // привести список пользователей к нужному размеру (добавить недостающее)
            while (users.size() < userCount) {
                prepareUser(role, groupList);
            }
        }

        Unit unit;
        int i = 0;
        for (String l : users.keySet()) {
            if (DEBUG_LEVEL > 0) System.out.printf("UserID=%s added " + '\n', users.get(l).getId());
            unit = new Unit(threadGroup, l, users.get(l), host, DEBUG_LEVEL, scriptID);
            collection.put(l, unit);
            i++;
        }
        em.close();
        emf.close();
        System.out.printf("Created %s threads" + '\n', i);
    }

    //    запуск потоков
    public void execute() {
        System.out.println("Start executing ...");
        for (Unit u : collection.values()) {
            u.start();
            try {
                u.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Executing stopping...");
        analyse();
    }

    //удаление пользователей
    @Deprecated
    public void removeUsers() {
        System.out.println("Start removing users ... ");
        int i = 0;
        for (AdmUser u : users.values()) {
            u.getRoles().clear();
            u.getGroups().clear();
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
            if (DEBUG_LEVEL > 0) System.out.printf("Removing UserId=%s" + '\n', u.getId());
            i++;
        }
        System.out.printf("Finished removing users. Removed %s users.", i);
        threadGroup.interrupt();
    }

    //    создание пользователя
    private AdmUser prepareUser(List<AdmRole> roleList, List<AdmGroup> groupList) {
        String login = String.format("user-%s", random.nextInt(100000));
        if (users.containsKey(login)) return null;
        AdmUser user = new AdmUser();
        user.setLogin(login);
        user.setAgentId(login);
        user.setFname(login);
        user.setLname(login);
        user.setEnabled(true);
        user.setDeleted(false);
        user.setDateCreate(new Date());
        user.setRoles(roleList);
        user.setGroups(groupList);
        user.setPassword(pe.encode(password));

        em.getTransaction().begin();
        user = em.merge(user);
        em.getTransaction().commit();

        users.put(user.getLogin(), user);
        return user;
    }

    private void analyse() {
        List<Long> l = new ArrayList<>();
        List<Long> sums = new ArrayList<>();
        Long generalSum = 0L;
        System.out.println("start analysing");
        int j = 0;
        for (Unit u : collection.values()) {
            Long sum = 0L;
            Long delta =0L;
            List<Long> time = u.getPerfomanceList();
            l.clear();
            int i = 0;
            while (i < time.size()) {
                delta = time.get(i + 1) - time.get(i);
                l.add(delta);
                i += 2;
                sum += delta;
            }
            sums.add(sum);
            generalSum += sum;
            System.out.printf("%s. UserID=%s, sum=%s ms. delta(ms)=%s" + '\n',++j, u.getUser().getId(), sum, Arrays.toString(l.toArray(new Long[l.size()])));
        }
        System.out.printf("Average: %s ms"+'\n', generalSum/sums.size());
        System.out.println("stop analysing");
    }
}

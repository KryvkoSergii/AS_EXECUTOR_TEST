package ua.com.smiddle.agent_scripting.core;

import org.hibernate.annotations.SourceType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Component;
import ua.com.smiddle.agent_scripting.core.model.AdmRole;
import ua.com.smiddle.agent_scripting.core.model.AdmUser;

import javax.annotation.PostConstruct;
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
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgentScripting");
    private EntityManager em = emf.createEntityManager();
    private Random random = new Random();
    private Map<String, AdmUser> users = new ConcurrentHashMap<>();
    private Map<String, Unit> collection = new ConcurrentHashMap<>();
    private Query query;
    private String tempRoleName = "test-role";
    private String password = "password";
    private PasswordEncoder pe = new BCryptPasswordEncoder(10);
    ThreadGroup threadGroup = new ThreadGroup("ThreadGroup");

    static {
        System.out.println("starting executor...");
    }

    private void initLoadingUsers() {
        em.getTransaction().begin();
        ArrayList<AdmUser> tmp = (ArrayList<AdmUser>) em.createQuery("SELECT u FROM AdmUser u", AdmUser.class).getResultList();
        em.getTransaction().commit();
        for (AdmUser u : tmp) {
            users.put(u.getLogin(), u);
        }
        System.out.printf("Initial load users ... %s" + '\n', users.size());
    }

    private AdmRole checkRole() {
        AdmRole testRole;
        em.getTransaction().begin();
        query = em.createQuery("SELECT r FROM AdmRole r where r.name=:name", AdmRole.class);
        em.setProperty("name", tempRoleName);
        ArrayList<AdmRole> tmp = (ArrayList<AdmRole>) query.getResultList();
        em.getTransaction().commit();
        if (tmp.isEmpty()) {
            testRole = new AdmRole();
            testRole.setName(tempRoleName);
            em.getTransaction().begin();
            testRole = em.merge(testRole);
            em.getTransaction().commit();
        } else {
            testRole = tmp.get(0);
        }
        return testRole;
    }

    public void prepare() {
//        initLoadingUsers();
        AdmRole role = checkRole();
        while (users.size() <= 5) {
            prepareUser(role);
        }
        Unit unit;
        int i = 0;
        for (String l : users.keySet()){
            System.out.printf("User %s add",l);
            unit = new Unit(threadGroup,l,users.get(l));
            i++;
        }
        System.out.printf("Created %s threads"+'\n',i);
    }

    public void execute() {

    }

    public void removeUsers() {
        System.out.println("Start removing users ... ");
        int i = 0;
        for (AdmUser u : users.values()) {
            em.remove(u);
            i++;
        }
        System.out.printf("Finished removing users. Removed %s users.", i);
    }

    private AdmUser prepareUser(AdmRole role) {
        String login = String.format("user-%s", random.nextInt(10000));
        if (users.containsKey(login)) return null;
        AdmUser user = new AdmUser();
        user.setLogin(login);
        user.setFname(login);
        user.setLname(login);
        user.setEnabled(true);
        user.setDeleted(false);
        user.setDateCreate(new Date());
        List<AdmRole> tmp = new ArrayList<>();
        tmp.add(role);
        user.setRoles(tmp);
        user.setPassword(pe.encode(password));

        em.getTransaction().begin();
        user = em.merge(user);
        em.getTransaction().commit();

        users.put(user.getLogin(), user);
        return user;
    }
}

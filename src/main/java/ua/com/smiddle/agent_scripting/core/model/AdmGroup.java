package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by srg on 10.05.16.
 */
@Entity
@Table(name = "ADM_GROUPS")
public class AdmGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID", foreignKey = @ForeignKey(name = "FK_PARENT_ID"))
    private AdmGroup parent;
    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<AdmUser> users;
    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private List<ScriptData> scripts;


    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdmGroup getParent() {
        return parent;
    }

    public void setParent(AdmGroup parent) {
        this.parent = parent;
    }

    public List<AdmUser> getUsers() {
        return users;
    }

    public void setUsers(List<AdmUser> users) {
        this.users = users;
    }

    public List<ScriptData> getScripts() {
        return scripts;
    }

    public void setScripts(List<ScriptData> scripts) {
        this.scripts = scripts;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdmGroup{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

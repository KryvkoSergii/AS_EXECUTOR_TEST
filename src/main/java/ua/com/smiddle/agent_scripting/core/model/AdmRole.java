package ua.com.smiddle.agent_scripting.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by srg on 10.05.16.
 */
@Entity
@Table(name = "ADM_ROLES", uniqueConstraints = @UniqueConstraint(name = "UK_ROLE_NAME", columnNames = {"NAME"}))
public class AdmRole implements Serializable, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AdmUser> users;
    @Transient
    private List<AdmTaskURL> tasks;


    //Getter and setters
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

    public List<AdmUser> getUsers() {
        return users;
    }

    public void setUsers(List<AdmUser> users) {
        this.users = users;
    }

    public List<AdmTaskURL> getTasks() {
        return tasks;
    }

    public void setTasks(List<AdmTaskURL> tasks) {
        this.tasks = tasks;
    }


    //Methods
    @JsonIgnore
    @Override
    public String getAuthority() {
        return String.format("ROLE_%s", this.name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdmRole{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

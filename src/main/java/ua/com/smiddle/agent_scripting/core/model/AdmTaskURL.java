package ua.com.smiddle.agent_scripting.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by srg on 30.05.16.
 */
@Entity
@Table(name = "ADM_TASK_URL")
@SqlResultSetMapping(
        name = "TaskContainer",
        entities = @EntityResult(
                entityClass = AdmTaskURL.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "url", column = "url")}),
        columns = @ColumnResult(name = "value", type = Integer.class))
public class AdmTaskURL implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "TASK_NAME", nullable = true)
    private String name;
    @JsonIgnore
    @Column(name = "URL", nullable = false)
    private String url;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ADM_URL_TASK_ROLES", uniqueConstraints = @UniqueConstraint(name = "UK_URL_TASK_ROLE", columnNames = {"URL_TASK_ID", "ROLE_ID"}),
            joinColumns = {@JoinColumn(name = "URL_TASK_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_URL_TASK_ROLE_ID"))},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ROLE_URL_TASK_ID"))})
    private List<AdmRole> roleList;
    //used to contain value 0 or 1 during JSON transport
    @Transient
    private Integer value;


    //Constructors
    public AdmTaskURL() {
    }

    public AdmTaskURL(String url) {
        this.url = url;
    }

    public AdmTaskURL(String url, String name) {
        this.url = url;
        this.name = name;
    }


    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AdmRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<AdmRole> roleList) {
        this.roleList = roleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdmTaskURL{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", roleList=").append(roleList);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

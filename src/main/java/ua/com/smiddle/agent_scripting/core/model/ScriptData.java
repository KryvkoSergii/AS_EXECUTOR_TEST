package ua.com.smiddle.agent_scripting.core.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by A.Osadchuk on 11.05.2016.
 */
@Entity
@Table(name = "SCRIPT_DATA")
public class ScriptData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CREATION_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "AUTHOR", nullable = true)
    private String author;
    @Column(name = "VERSION", nullable = true)
    private String version;
    @Column(name = "DESCRIPTION", nullable = true)
    private String description;
    @Type(type = "text")
    @Column(name = "SCRIPT_BODY", nullable = false)
    private String scriptBody;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SCRIPT_DATA_ADM_GROUPS", uniqueConstraints = @UniqueConstraint(name = "UK_SCRIPT_DATA_ADM_GROUP", columnNames = {"SCRIPT_DATA_ID", "ADM_GROUP_ID"}),
            joinColumns = {@JoinColumn(name = "SCRIPT_DATA_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_SCRIPT_DATA_ADM_GROUP_ID"))},
            inverseJoinColumns = {@JoinColumn(name = "ADM_GROUP_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ADM_GROUP_SCRIPT_DATA_ID"))})
    private List<AdmGroup> groups = new ArrayList<>();
    @Column(name = "DELETED", nullable = false)
    private boolean deleted;


    //Constructors
    public ScriptData() {
    }


    //Getters & setters
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<AdmGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<AdmGroup> groups) {
        this.groups = groups;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScriptBody() {
        return scriptBody;
    }

    public void setScriptBody(String scriptBody) {
        this.scriptBody = scriptBody;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptData{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", created=").append(created);
        sb.append(", group=").append(groups.size());
        sb.append(", author='").append(author).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", scriptBody='").append(scriptBody).append('\'');
        sb.append(", deleted=").append(deleted);
        sb.append('}');
        return sb.toString();
    }
}

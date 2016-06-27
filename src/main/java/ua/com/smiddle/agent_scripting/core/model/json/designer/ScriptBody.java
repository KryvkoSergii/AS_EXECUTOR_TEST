package ua.com.smiddle.agent_scripting.core.model.json.designer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by A.Osadchuk on 13.06.2016.
 */
public class ScriptBody implements Serializable {
    private Long id;
    private String name;
    private Date created;
    private String author;
    private String version;
    private String description;
    private List<Long> groups = new ArrayList<>();
    private String scriptBody;


    //Constructors
    public ScriptBody() {
    }

    public ScriptBody(Long id, String name, Date created, String author, String version, String description, String scriptBody) {
        this.scriptBody = scriptBody;
        this.description = description;
        this.version = version;
        this.author = author;
        this.created = created;
        this.name = name;
        this.id = id;
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

    public List<Long> getGroups() {
        return groups;
    }

    public void setGroups(List<Long> groups) {
        this.groups = groups;
    }

    public String getScriptBody() {
        return scriptBody;
    }

    public void setScriptBody(String scriptBody) {
        this.scriptBody = scriptBody;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptBody{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", created=").append(created);
        sb.append(", author='").append(author).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", groups=").append(groups.size());
        sb.append(", scriptBody='").append(scriptBody).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScriptBody)) return false;

        ScriptBody that = (ScriptBody) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

package ua.com.smiddle.agent_scripting.core.model.json.management;

import com.fasterxml.jackson.annotation.JsonProperty;
import ua.com.smiddle.agent_scripting.core.model.AdmGroup;

import java.io.Serializable;
import java.util.List;

/**
 * Created by srg on 31.05.16.
 */
public class GroupContainer implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parentID")
    private Long parentID;
    @JsonProperty("children")
    private List<GroupContainer> children;


    //Constructors
    public GroupContainer() {
    }

    public GroupContainer(Long id, String name, Long parentID, List<GroupContainer> children) {
        this.id = id;
        this.name = name;
        this.parentID = parentID;
        this.children = children;
    }

    public GroupContainer(AdmGroup group, List<GroupContainer> children) {
        this.id = group.getId();
        this.name = group.getName();
        this.parentID = group.getParent() != null ? group.getParent().getId() : null;
        this.children = children;
    }


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

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public List<GroupContainer> getChildren() {
        return children;
    }

    public void setChildren(List<GroupContainer> children) {
        this.children = children;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupContainer{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", parentID=").append(parentID);
        sb.append(", children=").append(children);
        sb.append('}');
        return sb.toString();
    }
}

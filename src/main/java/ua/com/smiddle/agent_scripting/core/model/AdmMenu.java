package ua.com.smiddle.agent_scripting.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by srg on 07.06.16.
 */
@Entity
@Table(name = "ADM_MENU",uniqueConstraints = {@UniqueConstraint(name = "UK_MENU_CODE",columnNames = {"CODE"})})
public class AdmMenu implements Serializable {
    private final static long serialVersionUID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonIgnore
    private Long id;
    @Column(name = "PARENT_ID",nullable = true)
    @JsonIgnore
    private Long parentId;
    @Column(name = "CODE", nullable = false)
    @JsonProperty("code")
    private String code;
    @Column(name = "IS_COMPONENT",nullable = false)
    @JsonIgnore
    private int isComponent;
    @Column(name = "NAME",nullable = false)
    @JsonProperty("name")
    private String name;
    @Column(name = "SORT_ORDER",nullable = true)
    @JsonIgnore
    private int sortOrder;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "URL_BE", foreignKey = @ForeignKey(name = "FK_URL_BE"))
    @JsonIgnore
    private AdmTaskURL url;
    @Transient
    @JsonProperty("child")
    private List<AdmMenu> child;


    //Constructors
    public AdmMenu() {
    }

    public AdmMenu(Long parentId, String code, int isComponent, String name, int sortOrder, AdmTaskURL url) {
        this.parentId = parentId;
        this.code = code;
        this.isComponent = isComponent;
        this.name = name;
        this.sortOrder = sortOrder;
        this.url = url;
    }

    //Getters and setters for menu
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIsComponent() {
        return isComponent;
    }

    public void setIsComponent(int isComponent) {
        this.isComponent = isComponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public AdmTaskURL getUrl() {
        return url;
    }

    public void setUrl(AdmTaskURL url) {
        this.url = url;
    }

    public List<AdmMenu> getChild() {
        return child;
    }

    public void setChild(List<AdmMenu> child) {
        this.child = child;
    }

    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdmMenu{");
        sb.append("id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", code='").append(code).append('\'');
        sb.append(", isComponent=").append(isComponent);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", url=").append(url);
        sb.append('}');
        return sb.toString();
    }
}

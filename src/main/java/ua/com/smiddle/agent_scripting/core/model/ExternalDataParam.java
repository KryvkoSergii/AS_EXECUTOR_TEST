package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by srg on 23.05.16.
 */
@Entity
@Table(name = "EXTERNAL_DATA_PARAMS")
public class ExternalDataParam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Long id;
    @Column(name = "KIND",nullable = false)
    private Integer kind;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column (name = "NAME_JSON",nullable = true)
    private String nameJson;
    @Column (name = "TYPE",nullable = false)
    private Integer type;

    //Constructors
    public ExternalDataParam() {
    }

    public ExternalDataParam(int kind, String name, String nameJson, int type) {
        this.kind = kind;
        this.name = name;
        this.nameJson = nameJson;
        this.type = type;
    }


    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameJson() {
        return nameJson;
    }

    public void setNameJson(String nameJson) {
        this.nameJson = nameJson;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExternalDataParams{");
        sb.append("id=").append(id);
        sb.append(", kind=").append(kind);
        sb.append(", name='").append(name).append('\'');
        sb.append(", nameJson='").append(nameJson).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}

package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by srg on 10.05.16.
 */
@Entity
@Table(name = "SCRIPT_OPERATION")
public class ScriptOperation implements Serializable {
    private final static long serialVersionUID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;


    //getters and setters
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
}

package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by A.Osadchuk on 10.05.2016.
 */
@Entity
@Table(name = "AS_SETTINGS")
public class Settings implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private volatile Long id;
    @Column(name = "DEBUG_LEVEL", nullable = false)
    private volatile int debugLevel;
    @Column(name = "LICENSE", nullable = false)
    private volatile String license;


    //Constructors
    public Settings() {
    }


    //Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDebugLevel() {
        return debugLevel;
    }

    public void setDebugLevel(int debugLevel) {
        this.debugLevel = debugLevel;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Settings{");
        sb.append("id=").append(id);
        sb.append(", debugLevel=").append(debugLevel);
        sb.append(", license='").append(license).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
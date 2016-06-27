package ua.com.smiddle.agent_scripting.core.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by A.Osadchuk on 10.05.2016.
 */
@Entity
@Table(name = "AS_LOGS")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "DATE_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Column(name = "MODULE_NAME", nullable = false)
    private String moduleName;
    @Type(type = "text")
    @Column(name = "MESSAGE", nullable = false)
    private String message;


    //Constructors
    public Log() {
    }

    public Log(Date dateTime, String moduleName, String message) {
        this.dateTime = dateTime;
        this.moduleName = moduleName;
        this.message = message;
    }


    //Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Log{");
        sb.append("id=").append(id);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", moduleName='").append(moduleName).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

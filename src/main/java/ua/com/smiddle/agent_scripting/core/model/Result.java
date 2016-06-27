package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by A.Osadchuk on 11.05.2016.
 */
@Entity
@Table(name = "SCRIPT_RESULTS")
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SCRIPT_NAME", nullable = true)
    private String scriptName;
    @Column(name = "SCRIPT_DESCRIPTION", nullable = true)
    private String scriptDescription;
    @Column(name = "CLIENT_ID", nullable = true)
    private String clientId;
    @Column(name = "ANI", nullable = true)
    private String ani;
    @Column(name = "DATE_START", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Column(name = "DATE_END", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @Column(name = "CURRENT_SCRIPT_ID", nullable = false)
    private long currentScriptId;
    @Column(name = "CURRENT_ELEMENT_ID", nullable = false)
    private int currentElementId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private AdmUser user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCRIPT_DATA_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_SCRIPT_DATA_ID"))
    private ScriptData scriptData;
    @OneToMany(mappedBy = "result", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ResultElement> elements = new ArrayList<>();


    //Constructors
    public Result() {
    }

    public Result(String scriptName, String scriptDescription, String clientId, String ani, Date dateStart, Date dateEnd, long currentScriptId, int currentElementId, AdmUser user, ScriptData scriptData) {
        this.scriptName = scriptName;
        this.scriptDescription = scriptDescription;
        this.clientId = clientId;
        this.ani = ani;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.currentScriptId = currentScriptId;
        this.currentElementId = currentElementId;
        this.user = user;
        this.scriptData = scriptData;
    }


    //Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getScriptDescription() {
        return scriptDescription;
    }

    public void setScriptDescription(String scriptDescription) {
        this.scriptDescription = scriptDescription;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public long getCurrentScriptId() {
        return currentScriptId;
    }

    public void setCurrentScriptId(long currentScriptId) {
        this.currentScriptId = currentScriptId;
    }

    public int getCurrentElementId() {
        return currentElementId;
    }

    public void setCurrentElementId(int currentElementId) {
        this.currentElementId = currentElementId;
    }

    public AdmUser getUser() {
        return user;
    }

    public void setUser(AdmUser user) {
        this.user = user;
    }

    public ScriptData getScriptData() {
        return scriptData;
    }

    public void setScriptData(ScriptData scriptData) {
        this.scriptData = scriptData;
    }

    public List<ResultElement> getElements() {
        return elements;
    }

    public void setElements(List<ResultElement> elements) {
        this.elements = elements;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("id=").append(id);
        sb.append(", scriptName='").append(scriptName).append('\'');
        sb.append(", scriptDescription='").append(scriptDescription).append('\'');
        sb.append(", clientId='").append(clientId).append('\'');
        sb.append(", ani='").append(ani).append('\'');
        sb.append(", dateStart=").append(dateStart);
        sb.append(", dateEnd=").append(dateEnd);
        sb.append(", currentScriptId=").append(currentScriptId);
        sb.append(", currentElementId=").append(currentElementId);
        sb.append(", user=").append(user.getId());
        sb.append(", scriptData=").append(scriptData.getId());
        sb.append(", elements=").append(elements.size());
        sb.append('}');
        return sb.toString();
    }
}

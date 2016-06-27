package ua.com.smiddle.agent_scripting.core.model.json.designer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by A.Osadchuk on 13.05.2016.
 */
public class DesignerRequest implements Serializable {
    private Long scriptId;
    private Long groupId;
    private Date dateFrom;
    private Date dateTo;
    private String scriptName;
    private String scriptAuthor;


    //Constructors
    public DesignerRequest() {
    }


    //Getters & setters
    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getScriptAuthor() {
        return scriptAuthor;
    }

    public void setScriptAuthor(String scriptAuthor) {
        this.scriptAuthor = scriptAuthor;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DesignerRequest{");
        sb.append("scriptId=").append(scriptId);
        sb.append(", groupId=").append(groupId);
        sb.append(", dateFrom=").append(dateFrom);
        sb.append(", dateTo=").append(dateTo);
        sb.append(", scriptName='").append(scriptName).append('\'');
        sb.append(", scriptAuthor='").append(scriptAuthor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

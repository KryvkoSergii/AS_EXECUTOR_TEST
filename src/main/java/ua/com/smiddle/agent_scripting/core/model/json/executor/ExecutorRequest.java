package ua.com.smiddle.agent_scripting.core.model.json.executor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ExecutorRequest implements Serializable {
    private Long scriptId;
    private String agentId;
    private String clientId;
    private String ani;
    private String comment;
    private List<ExecutorRequestVariable> variables;


    //Constructors
    public ExecutorRequest() {
    }


    //Getters & setters
    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ExecutorRequestVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<ExecutorRequestVariable> variables) {
        this.variables = variables;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExecutorRequest{");
        sb.append("scriptId=").append(scriptId);
        sb.append(", agentId=").append(agentId);
        sb.append(", clientId='").append(clientId).append('\'');
        sb.append(", ani='").append(ani).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", variables=").append(variables);
        sb.append('}');
        return sb.toString();
    }
}

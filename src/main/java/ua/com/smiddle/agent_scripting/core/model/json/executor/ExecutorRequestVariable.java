package ua.com.smiddle.agent_scripting.core.model.json.executor;

import java.io.Serializable;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ExecutorRequestVariable implements Serializable {
    private int variableId;
    private String data;


    //Constructors
    public ExecutorRequestVariable() {
    }

    public ExecutorRequestVariable(int variableId, String data) {
        this.variableId = variableId;
        this.data = data;
    }

    //Getters & setters
    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExecutorRequestVariable{");
        sb.append("variableId=").append(variableId);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

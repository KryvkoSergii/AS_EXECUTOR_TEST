package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ScriptNextParam implements Serializable {
    private int nextScriptParamId;
    private int paramType;

    private int currentScriptElementId;
    private int currentScriptVariableId;

    private int nextScriptElementId;
    private int nextScriptVariableId;


    //Constructors
    public ScriptNextParam() {
    }


    //Getters & setters
    public int getNextScriptParamId() {
        return nextScriptParamId;
    }

    public void setNextScriptParamId(int nextScriptParamId) {
        this.nextScriptParamId = nextScriptParamId;
    }

    public int getParamType() {
        return paramType;
    }

    public void setParamType(int paramType) {
        this.paramType = paramType;
    }

    public int getCurrentScriptElementId() {
        return currentScriptElementId;
    }

    public void setCurrentScriptElementId(int currentScriptElementId) {
        this.currentScriptElementId = currentScriptElementId;
    }

    public int getCurrentScriptVariableId() {
        return currentScriptVariableId;
    }

    public void setCurrentScriptVariableId(int currentScriptVariableId) {
        this.currentScriptVariableId = currentScriptVariableId;
    }

    public int getNextScriptElementId() {
        return nextScriptElementId;
    }

    public void setNextScriptElementId(int nextScriptElementId) {
        this.nextScriptElementId = nextScriptElementId;
    }

    public int getNextScriptVariableId() {
        return nextScriptVariableId;
    }

    public void setNextScriptVariableId(int nextScriptVariableId) {
        this.nextScriptVariableId = nextScriptVariableId;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptNextParam{");
        sb.append("nextScriptParamId=").append(nextScriptParamId);
        sb.append(", paramType=").append(paramType);
        sb.append(", currentScriptElementId=").append(currentScriptElementId);
        sb.append(", currentScriptVariableId=").append(currentScriptVariableId);
        sb.append(", nextScriptElementId=").append(nextScriptElementId);
        sb.append(", nextScriptVariableId=").append(nextScriptVariableId);
        sb.append('}');
        return sb.toString();
    }
}

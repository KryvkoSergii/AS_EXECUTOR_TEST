package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;

/**
 * Created by A.Osadchuk on 08.06.2016.
 */
public class ScriptExternalDataParam implements Serializable{
    private Long paramId;
    private int paramType;
    private int elementId;
    private int variableId;


    //Constructors
    public ScriptExternalDataParam() {
    }


    //Getters & setters
    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public int getParamType() {
        return paramType;
    }

    public void setParamType(int paramType) {
        this.paramType = paramType;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptExternalDataParam{");
        sb.append("paramId=").append(paramId);
        sb.append(", paramType=").append(paramType);
        sb.append(", elementId=").append(elementId);
        sb.append(", variableId=").append(variableId);
        sb.append('}');
        return sb.toString();
    }
}

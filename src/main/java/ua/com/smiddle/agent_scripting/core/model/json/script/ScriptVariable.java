package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ScriptVariable implements Serializable {
    private int variableId;
    private String variableTitle;
    private String assignedValue;
    private int displayOption;
    private int dataType;
    private int required;
    private int isValueList;
    private int fromElementId;
    private int fromVariableId;
    private List<ScriptDefaultValue> defaultValues;


    //Constructors
    public ScriptVariable() {
    }


    //Getters & setters
    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

    public String getVariableTitle() {
        return variableTitle;
    }

    public void setVariableTitle(String variableTitle) {
        this.variableTitle = variableTitle;
    }

    public String getAssignedValue() {
        return assignedValue;
    }

    public void setAssignedValue(String assignedValue) {
        this.assignedValue = assignedValue;
    }

    public int getDisplayOption() {
        return displayOption;
    }

    public void setDisplayOption(int displayOption) {
        this.displayOption = displayOption;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public int isValueList() {
        return isValueList;
    }

    public void setIsValueList(int isValueList) {
        this.isValueList = isValueList;
    }

    public int getFromElementId() {
        return fromElementId;
    }

    public void setFromElementId(int fromElementId) {
        this.fromElementId = fromElementId;
    }

    public int getFromVariableId() {
        return fromVariableId;
    }

    public void setFromVariableId(int fromVariableId) {
        this.fromVariableId = fromVariableId;
    }

    public List<ScriptDefaultValue> getDefaultValues() {
        return defaultValues;
    }

    public void setDefaultValues(List<ScriptDefaultValue> defaultValues) {
        this.defaultValues = defaultValues;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptVariable{");
        sb.append("variableId=").append(variableId);
        sb.append(", variableTitle='").append(variableTitle).append('\'');
        sb.append(", assignedValue='").append(assignedValue).append('\'');
        sb.append(", displayOption=").append(displayOption);
        sb.append(", dataType=").append(dataType);
        sb.append(", required=").append(required);
        sb.append(", isValueList=").append(isValueList);
        sb.append(", fromElementId=").append(fromElementId);
        sb.append(", fromVariableId=").append(fromVariableId);
        sb.append(", defaultValues=").append(defaultValues);
        sb.append('}');
        return sb.toString();
    }
}

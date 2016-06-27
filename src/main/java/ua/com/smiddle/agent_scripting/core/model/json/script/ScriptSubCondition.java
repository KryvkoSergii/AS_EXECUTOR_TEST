package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ScriptSubCondition implements Serializable {
    private int subConditionId;
    private int elementId1;
    private int variableId1;
    private int comparisonType;
    private int isValue;
    private int elementId2;
    private int variableId2;
    private String value2;


    //Constructors
    public ScriptSubCondition() {
    }


    //Getters & setters
    public int getSubConditionId() {
        return subConditionId;
    }

    public void setSubConditionId(int subConditionId) {
        this.subConditionId = subConditionId;
    }

    public int getElementId1() {
        return elementId1;
    }

    public void setElementId1(int elementId1) {
        this.elementId1 = elementId1;
    }

    public int getVariableId1() {
        return variableId1;
    }

    public void setVariableId1(int variableId1) {
        this.variableId1 = variableId1;
    }

    public int getComparisonType() {
        return comparisonType;
    }

    public void setComparisonType(int comparisonType) {
        this.comparisonType = comparisonType;
    }

    public int isValue() {
        return isValue;
    }

    public void setIsValue(int isValue) {
        this.isValue = isValue;
    }

    public int getElementId2() {
        return elementId2;
    }

    public void setElementId2(int elementId2) {
        this.elementId2 = elementId2;
    }

    public int getVariableId2() {
        return variableId2;
    }

    public void setVariableId2(int variableId2) {
        this.variableId2 = variableId2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptSubCondition{");
        sb.append("subConditionId=").append(subConditionId);
        sb.append(", elementId1=").append(elementId1);
        sb.append(", variableId1=").append(variableId1);
        sb.append(", comparisonType=").append(comparisonType);
        sb.append(", isValue=").append(isValue);
        sb.append(", elementId2=").append(elementId2);
        sb.append(", variableId2=").append(variableId2);
        sb.append(", value2='").append(value2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

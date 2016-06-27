package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ScriptOperation implements Serializable {
    private int operationId;
    private int toElementId;
    private int toVariableId;
    private int isValue1;
    private int elementId1;
    private int variableId1;
    private String value1;
    private int arithmeticOperationType;
    private int isValue2;
    private int elementId2;
    private int variableId2;
    private String value2;


    //Constructors
    public ScriptOperation() {
    }


    //Getters & setters
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public int getToElementId() {
        return toElementId;
    }

    public void setToElementId(int toElementId) {
        this.toElementId = toElementId;
    }

    public int getToVariableId() {
        return toVariableId;
    }

    public void setToVariableId(int toVariableId) {
        this.toVariableId = toVariableId;
    }

    public int isValue1() {
        return isValue1;
    }

    public void setIsValue1(int isValue1) {
        this.isValue1 = isValue1;
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

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public int getArithmeticOperationType() {
        return arithmeticOperationType;
    }

    public void setArithmeticOperationType(int arithmeticOperationType) {
        this.arithmeticOperationType = arithmeticOperationType;
    }

    public int isValue2() {
        return isValue2;
    }

    public void setIsValue2(int isValue2) {
        this.isValue2 = isValue2;
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
        final StringBuilder sb = new StringBuilder("ScriptOperation{");
        sb.append("operationId=").append(operationId);
        sb.append(", toElementId=").append(toElementId);
        sb.append(", toVariableId=").append(toVariableId);
        sb.append(", isValue1=").append(isValue1);
        sb.append(", elementId1=").append(elementId1);
        sb.append(", variableId1=").append(variableId1);
        sb.append(", value1='").append(value1).append('\'');
        sb.append(", arithmeticOperationType=").append(arithmeticOperationType);
        sb.append(", isValue2=").append(isValue2);
        sb.append(", elementId2=").append(elementId2);
        sb.append(", variableId2=").append(variableId2);
        sb.append(", value2='").append(value2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

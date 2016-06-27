package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ScriptElement implements Serializable {
    private int elementId;
    private int elementType;
    private String elementName;
    private String elementTitle;
    private String elementHeader;
    private String elementFooter;
    private Long nextScriptId;
    private boolean isProcessed;
    private int x;
    private int y;
    private List<ScriptCondition> conditions;
    private List<ScriptVariable> variables;
    private List<ScriptOperation> operations;
    private List<ScriptNextParam> nextScriptParams;
    private List<ScriptExternalData> externalDatas;


    //Constructors
    public ScriptElement() {
    }


    //Getters & setters
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getElementType() {
        return elementType;
    }

    public void setElementType(int elementType) {
        this.elementType = elementType;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementTitle() {
        return elementTitle;
    }

    public void setElementTitle(String elementTitle) {
        this.elementTitle = elementTitle;
    }

    public String getElementHeader() {
        return elementHeader;
    }

    public void setElementHeader(String elementHeader) {
        this.elementHeader = elementHeader;
    }

    public String getElementFooter() {
        return elementFooter;
    }

    public void setElementFooter(String elementFooter) {
        this.elementFooter = elementFooter;
    }

    public Long getNextScriptId() {
        return nextScriptId;
    }

    public void setNextScriptId(Long nextScriptId) {
        this.nextScriptId = nextScriptId;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<ScriptCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<ScriptCondition> conditions) {
        this.conditions = conditions;
    }

    public List<ScriptVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<ScriptVariable> variables) {
        this.variables = variables;
    }

    public List<ScriptOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<ScriptOperation> operations) {
        this.operations = operations;
    }

    public List<ScriptNextParam> getNextScriptParams() {
        return nextScriptParams;
    }

    public void setNextScriptParams(List<ScriptNextParam> nextScriptParams) {
        this.nextScriptParams = nextScriptParams;
    }

    public List<ScriptExternalData> getExternalDatas() {
        return externalDatas;
    }

    public void setExternalDatas(List<ScriptExternalData> externalDatas) {
        this.externalDatas = externalDatas;
    }

    //Methods
    public ScriptElement clone() {
        ScriptElement newElement = new ScriptElement();
        newElement.setElementId(elementId);
        newElement.setElementType(elementType);
        newElement.setElementName(elementName);
        newElement.setElementTitle(elementTitle);
        newElement.setElementHeader(new String(elementHeader));
        newElement.setElementFooter(new String(elementFooter));
        newElement.setNextScriptId(nextScriptId);
        newElement.setIsProcessed(isProcessed);
        newElement.setConditions(conditions);
        newElement.setVariables(variables);
        newElement.setOperations(operations);
        newElement.setNextScriptParams(nextScriptParams);
        newElement.setExternalDatas(externalDatas);
        newElement.setX(x);
        newElement.setY(y);
        return newElement;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptElement{");
        sb.append("elementId=").append(elementId);
        sb.append(", elementType=").append(elementType);
        sb.append(", elementName='").append(elementName).append('\'');
        sb.append(", elementTitle='").append(elementTitle).append('\'');
        sb.append(", elementHeader='").append(elementHeader).append('\'');
        sb.append(", elementFooter='").append(elementFooter).append('\'');
        sb.append(", nextScriptId=").append(nextScriptId);
        sb.append(", isProcessed=").append(isProcessed);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", conditions=").append(conditions.size());
        sb.append(", variables=").append(variables.size());
        sb.append(", operations=").append(operations.size());
        sb.append(", nextScriptParams=").append(nextScriptParams.size());
        sb.append(", externalDatas=").append(externalDatas.size());
        sb.append('}');
        return sb.toString();
    }
}

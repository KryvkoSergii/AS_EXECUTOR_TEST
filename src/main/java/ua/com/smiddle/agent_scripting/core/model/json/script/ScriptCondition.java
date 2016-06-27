package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ScriptCondition implements Serializable {
    private int conditionId;
    private String conditionName;
    private int nextElementId;
    private int logicOperatorType;
    private int linkType;
    private List<ScriptSubCondition> subConditions;


    //Constructors
    public ScriptCondition() {
    }


    //Getters & setters
    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public int getNextElementId() {
        return nextElementId;
    }

    public void setNextElementId(int nextElementId) {
        this.nextElementId = nextElementId;
    }

    public int getLogicOperatorType() {
        return logicOperatorType;
    }

    public void setLogicOperatorType(int logicOperatorType) {
        this.logicOperatorType = logicOperatorType;
    }

    public int getLinkType() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }

    public List<ScriptSubCondition> getSubConditions() {
        return subConditions;
    }

    public void setSubConditions(List<ScriptSubCondition> subConditions) {
        this.subConditions = subConditions;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptCondition{");
        sb.append("conditionId=").append(conditionId);
        sb.append(", conditionName='").append(conditionName).append('\'');
        sb.append(", nextElementId=").append(nextElementId);
        sb.append(", logicOperatorType=").append(logicOperatorType);
        sb.append(", linkType=").append(linkType);
        sb.append(", subConditions=").append(subConditions);
        sb.append('}');
        return sb.toString();
    }
}

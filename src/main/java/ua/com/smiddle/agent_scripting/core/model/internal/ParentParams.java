package ua.com.smiddle.agent_scripting.core.model.internal;

/**
 * Created by A.Osadchuk on 31.05.2016.
 */
public class ParentParams {
    private long parentScriptId;
    private int parentElementId;


    //Constructors
    public ParentParams() {
    }

    public ParentParams(long parentScriptId, int parentElementId) {
        this.parentScriptId = parentScriptId;
        this.parentElementId = parentElementId;
    }


    //Getters & setters
    public long getParentScriptId() {
        return parentScriptId;
    }

    public void setParentScriptId(long parentScriptId) {
        this.parentScriptId = parentScriptId;
    }

    public int getParentElementId() {
        return parentElementId;
    }

    public void setParentElementId(int parentElementId) {
        this.parentElementId = parentElementId;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParentParams{");
        sb.append("parentScriptId=").append(parentScriptId);
        sb.append(", parentElementId=").append(parentElementId);
        sb.append('}');
        return sb.toString();
    }
}

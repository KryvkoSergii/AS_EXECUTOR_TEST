package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;

/**
 * Created by A.Osadchuk on 26.05.2016.
 */
public class ScriptDefaultValue implements Serializable {
    private int valueId;
    private String data;


    //Constructors
    public ScriptDefaultValue() {
    }

    public ScriptDefaultValue(int valueId, String data) {
        this.valueId = valueId;
        this.data = data;
    }


    //Getters & setters
    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
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
        final StringBuilder sb = new StringBuilder("ScriptDefaultValue{");
        sb.append("valueId=").append(valueId);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

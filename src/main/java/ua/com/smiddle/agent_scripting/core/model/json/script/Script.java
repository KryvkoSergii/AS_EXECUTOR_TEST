package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Osadchuk on 16.05.2016.
 */
public class Script implements Serializable {
    private List<ScriptElement> elements;


    //Constructors
    public Script() {
    }


    //Getters & setters
    public List<ScriptElement> getElements() {
        return elements;
    }

    public void setElements(List<ScriptElement> elements) {
        this.elements = elements;
    }

    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Script{");
        sb.append("elements=").append(elements);
        sb.append('}');
        return sb.toString();
    }
}

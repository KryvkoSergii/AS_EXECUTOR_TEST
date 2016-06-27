package ua.com.smiddle.agent_scripting.core.model.json.script;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Osadchuk on 01.06.2016.
 */
public class ScriptExternalData implements Serializable {
    private Long externalDataId;
    private List<ScriptExternalDataParam> paramsIn;
    private List<ScriptExternalDataParam> paramsOut;


    //Constructors
    public ScriptExternalData() {
    }


    //Getters & setters
    public Long getExternalDataId() {
        return externalDataId;
    }

    public void setExternalDataId(Long externalDataId) {
        this.externalDataId = externalDataId;
    }

    public List<ScriptExternalDataParam> getParamsIn() {
        return paramsIn;
    }

    public void setParamsIn(List<ScriptExternalDataParam> paramsIn) {
        this.paramsIn = paramsIn;
    }

    public List<ScriptExternalDataParam> getParamsOut() {
        return paramsOut;
    }

    public void setParamsOut(List<ScriptExternalDataParam> paramsOut) {
        this.paramsOut = paramsOut;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScriptExternalData{");
        sb.append("externalDataId=").append(externalDataId);
        sb.append(", paramsIn=").append(paramsIn);
        sb.append(", paramsOut=").append(paramsOut);
        sb.append('}');
        return sb.toString();
    }
}

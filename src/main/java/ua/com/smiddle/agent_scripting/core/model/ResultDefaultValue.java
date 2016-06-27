package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by A.Osadchuk on 02.06.2016.
 */
@Entity
@Table(name = "SCRIPT_RESULT_DEFAULT_VALUES")
public class ResultDefaultValue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "VALUE_ID", nullable = false)
    private int valueId;
    @Column(name = "DATA", nullable = false)
    private String data;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCRIPT_RESULT_VARIABLE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_SCRIPT_RESULT_VARIABLE_ID"))
    private ResultVariable variable;


    //Constructors
    public ResultDefaultValue() {
    }

    public ResultDefaultValue(int valueId, String data, ResultVariable variable) {
        this.valueId = valueId;
        this.data = data;
        this.variable = variable;
    }


    //Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ResultVariable getVariable() {
        return variable;
    }

    public void setVariable(ResultVariable variable) {
        this.variable = variable;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultDefaultValue{");
        sb.append("id=").append(id);
        sb.append(", valueId=").append(valueId);
        sb.append(", data='").append(data).append('\'');
        sb.append(", variable=").append(variable.getId());
        sb.append('}');
        return sb.toString();
    }
}

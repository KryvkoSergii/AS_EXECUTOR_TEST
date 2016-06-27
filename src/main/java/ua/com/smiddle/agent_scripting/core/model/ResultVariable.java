package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.Osadchuk on 11.05.2016.
 */
@Entity
@Table(name = "SCRIPT_RESULT_VARIABLES")
public class ResultVariable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ELEMENT_VARIABLE_ID", nullable = false)
    private int elementVariableId;
    @Column(name = "VARIABLE_ID", nullable = false)
    private int variableId;
    @Column(name = "VARIABLE_TITLE", nullable = false)
    private String variableTitle;
    @Column(name = "VARIABLE_VALUE", nullable = true)
    private String variableValue;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCRIPT_RESULT_ELEMENT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_SCRIPT_RESULT_ELEMENT_ID"))
    private ResultElement resultElement;
    @OneToMany(mappedBy = "variable", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ResultDefaultValue> defaultValues = new ArrayList<>();


    //Constructors
    public ResultVariable() {
    }

    public ResultVariable(int elementVariableId, int variableId, String variableTitle, String variableValue, ResultElement resultElement) {
        this.elementVariableId = elementVariableId;
        this.variableId = variableId;
        this.variableTitle = variableTitle;
        this.variableValue = variableValue;
        this.resultElement = resultElement;
    }


    //Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getElementVariableId() {
        return elementVariableId;
    }

    public void setElementVariableId(int elementVariableId) {
        this.elementVariableId = elementVariableId;
    }

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

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    public ResultElement getResultElement() {
        return resultElement;
    }

    public void setResultElement(ResultElement resultElement) {
        this.resultElement = resultElement;
    }

    public List<ResultDefaultValue> getDefaultValues() {
        return defaultValues;
    }

    public void setDefaultValues(List<ResultDefaultValue> defaultValues) {
        this.defaultValues = defaultValues;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultVariable{");
        sb.append("id=").append(id);
        sb.append(", elementVariableId=").append(elementVariableId);
        sb.append(", variableId=").append(variableId);
        sb.append(", variableTitle='").append(variableTitle).append('\'');
        sb.append(", variableValue='").append(variableValue).append('\'');
        sb.append(", resultElement=").append(resultElement.getId());
        sb.append(", defaultValues=").append(defaultValues.size());
        sb.append('}');
        return sb.toString();
    }
}

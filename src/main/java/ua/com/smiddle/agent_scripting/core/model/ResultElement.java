package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by A.Osadchuk on 11.05.2016.
 */
@Entity
@Table(name = "SCRIPT_RESULT_ELEMENTS")
public class ResultElement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SCRIPT_ID", nullable = false)
    private long scriptId;
    @Column(name = "SCRIPT_NAME", nullable = false)
    private String scriptName;
    @Column(name = "ELEMENT_ID", nullable = false)
    private int elementId;
    @Column(name = "ELEMENT_NAME", nullable = false)
    private String elementName;
    @Column(name = "ELEMENT_TITLE", nullable = false)
    private String elementTitle;
    @Column(name = "ELEMENT_HEADER", nullable = false)
    private String elementHeader;
    @Column(name = "ELEMENT_FOOTER", nullable = false)
    private String elementFooter;
    @Column(name = "COMMENT", nullable = true)
    private String comment;
    @Column(name = "ELEMENT_TYPE", nullable = false)
    private int elementType;
    @Column(name = "PROCESS_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Column(name = "PARENT_SCRIPT_ID", nullable = true)
    private Long parentScriptId;
    @Column(name = "PARENT_ELEMENT_ID", nullable = true)
    private int parentElementId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCRIPT_RESULT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_SCRIPT_RESULT_ID"))
    private Result result;
    @OneToMany(mappedBy = "resultElement", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ResultVariable> variables = new ArrayList<>();


    //Constructors
    public ResultElement() {
    }


    //Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getScriptId() {
        return scriptId;
    }

    public void setScriptId(long scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getElementType() {
        return elementType;
    }

    public void setElementType(int elementType) {
        this.elementType = elementType;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Long getParentScriptId() {
        return parentScriptId;
    }

    public void setParentScriptId(Long parrantScriptId) {
        this.parentScriptId = parrantScriptId;
    }

    public int getParentElementId() {
        return parentElementId;
    }

    public void setParentElementId(int parrantElementId) {
        this.parentElementId = parrantElementId;
    }

    public List<ResultVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<ResultVariable> variables) {
        this.variables = variables;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultElement{");
        sb.append("id=").append(id);
        sb.append(", scriptId=").append(scriptId);
        sb.append(", scriptName='").append(scriptName).append('\'');
        sb.append(", elementId=").append(elementId);
        sb.append(", elementName='").append(elementName).append('\'');
        sb.append(", elementTitle='").append(elementTitle).append('\'');
        sb.append(", elementHeader='").append(elementHeader).append('\'');
        sb.append(", elementFooter='").append(elementFooter).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", elementType=").append(elementType);
        sb.append(", processDate=").append(processDate);
        sb.append(", result=").append(result.getId());
        sb.append(", parentScriptId=").append(parentScriptId);
        sb.append(", parentElementId=").append(parentElementId);
        sb.append(", variables=").append(variables.size());
        sb.append('}');
        return sb.toString();
    }
}

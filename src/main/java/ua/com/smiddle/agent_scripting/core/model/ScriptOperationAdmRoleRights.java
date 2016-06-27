package ua.com.smiddle.agent_scripting.core.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by srg on 10.05.16.
 */
@Entity
@Table(name = "SCRIPT_OPERATION_ROLE_RIGHTS")
public class ScriptOperationAdmRoleRights implements Serializable {
    private final static long serialVersionUID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name = "SCRIPT_OPERATION_ID", nullable = false)
    private ScriptOperation scriptOperation_id;
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private AdmRole role_id;
    @Column(name = "ALLOW_VIEW", nullable = false)
    private boolean allowView = false;
    @Column(name = "ALLOW_CREATE", nullable = false)
    private boolean allowCreate = false;
    @Column(name = "ALLOW_EDIT", nullable = false)
    private boolean allowEdit = false;
    @Column(name = "ALLOW_DELETE", nullable = false)
    private boolean allowDelete = false;


    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScriptOperation getScriptOperation_id() {
        return scriptOperation_id;
    }

    public void setScriptOperation_id(ScriptOperation scriptOperation_id) {
        this.scriptOperation_id = scriptOperation_id;
    }

    public AdmRole getRole_id() {
        return role_id;
    }

    public void setRole_id(AdmRole role_id) {
        this.role_id = role_id;
    }

    public boolean isAllowView() {
        return allowView;
    }

    public void setAllowView(boolean allowView) {
        this.allowView = allowView;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public boolean isAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public boolean isAllowCreate() {
        return allowCreate;
    }

    public void setAllowCreate(boolean allowCreate) {
        this.allowCreate = allowCreate;
    }


    //methods
    @Override
    public String toString() {
        return "ScriptOperationAdmRoleRights{" +
                "id=" + id +
                ", scriptOperation_id=" + scriptOperation_id +
                ", role_id=" + role_id +
                ", allowView=" + allowView +
                ", allowCreate=" + allowCreate +
                ", allowEdit=" + allowEdit +
                ", allowDelete=" + allowDelete +
                '}';
    }
}

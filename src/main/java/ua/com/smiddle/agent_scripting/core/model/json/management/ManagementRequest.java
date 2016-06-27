package ua.com.smiddle.agent_scripting.core.model.json.management;

/**
 * Created by srg on 13.05.16.
 */
public class ManagementRequest {
    private String fName;
    private String lName;
    private String pName;
    private Long roleId;
    private Long userId;
    private Long groupId;
    private Long scriptId;


    //constructors
    public ManagementRequest() {
    }

    public ManagementRequest(String fName, String lName, String pName, Long roleId, Long userId, Long groupId) {
        this.fName = fName;
        this.lName = lName;
        this.pName = pName;
        this.roleId = roleId;
        this.userId = userId;
        this.groupId = groupId;
    }


    //Getters and setters
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    //Method
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ManagementRequest{");
        sb.append("fName='").append(fName).append('\'');
        sb.append(", lName='").append(lName).append('\'');
        sb.append(", pName='").append(pName).append('\'');
        sb.append(", roleId=").append(roleId);
        sb.append(", userId=").append(userId);
        sb.append(", groupId=").append(groupId);
        sb.append(", scriptId=").append(scriptId);
        sb.append('}');
        return sb.toString();
    }
}

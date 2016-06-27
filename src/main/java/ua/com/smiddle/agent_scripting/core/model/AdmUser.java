package ua.com.smiddle.agent_scripting.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by srg on 10.05.16.
 */
@Entity
@Table(name = "ADM_USERS", uniqueConstraints = @UniqueConstraint(name = "UK_USER_LOGIN", columnNames = {"LOGIN"}))
public class AdmUser implements Serializable, UserDetails, CredentialsContainer {
    private final static long serialVersionUID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "LOGIN", nullable = false)
    private String login;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;
    @Column(name = "LOCALE", nullable = true)
    private String locale;
    @Column(name = "DATE_CREATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "LAST_NAME", nullable = false)
    private String lname;
    @Column(name = "FIRST_NAME", nullable = false)
    private String fname;
    @Column(name = "PATRONYMIC_NAME", nullable = true)
    private String pname;
    @Column(name = "E_MAIL", nullable = true)
    private String email;
    @Column(name = "PHONE", nullable = true)
    private String phone;
    @Column(name = "FAX", nullable = true)
    private String fax;
    @Column(name = "AGENT_ID", nullable = true)
    private String agentId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ADM_USERS_GROUPS", uniqueConstraints = @UniqueConstraint(name = "UK_USER_GROUP", columnNames = {"USER_ID", "GROUP_ID"}),
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_USER_GROUP_ID"))},
            inverseJoinColumns = {@JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_GROUP_USER_ID"))})
    private List<AdmGroup> groups = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ADM_USERS_ROLES", uniqueConstraints = @UniqueConstraint(name = "UK_USER_ROLE", columnNames = {"USER_ID", "ROLE_ID"}),
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_USER_ROLE_ID"))},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ROLE_USER_ID"))})
    private List<AdmRole> roles = new ArrayList<>();
    @Column(name = "DELETED", nullable = false)
    private boolean deleted;


    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<AdmRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AdmRole> roles) {
        this.roles = roles;
    }

    public List<AdmGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<AdmGroup> group) {
        this.groups = group;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    //Methods
    @Override
    public int hashCode() {
        return this.login.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof AdmUser)) return false;
        AdmUser temp = (AdmUser) obj;
        return this.login.equals(temp.getLogin());
    }


    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }


    @JsonIgnore
    public String getUsername() {
        return this.login;
    }


    @JsonIgnore
    public boolean isAccountNonExpired() {
        return !deleted;
    }


    @JsonIgnore
    public boolean isAccountNonLocked() {
        return enabled;
    }


    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @JsonIgnore
    public void eraseCredentials() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdmUser{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", agentId='").append(agentId).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append(", locale='").append(locale).append('\'');
        sb.append(", dateCreate=").append(dateCreate);
        sb.append(", lname='").append(lname).append('\'');
        sb.append(", fname='").append(fname).append('\'');
        sb.append(", pname='").append(pname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", fax='").append(fax).append('\'');
        sb.append(", groups=").append(groups);
        sb.append(", roles=").append(roles);
        sb.append(", deleted=").append(deleted);
        sb.append('}');
        return sb.toString();
    }
}

package ua.com.smiddle.agent_scripting.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by srg on 23.05.16.
 */
@Entity
@Table(name = "EXTERNAL_DATA")
public class ExternalData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "REST_METHOD", nullable = true)
    private String restMethod;
    @Column(name = "URL", nullable = true)
    private String url;
    @Column(name = "CREATED", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "OWNER_GROUP_ID", nullable = true)
    private Long ownerGroupId;
    @Column(name = "OWNER_USER_ID", nullable = true)
    private Long ownerUserId;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "EXTERNAL_DATA_PARAMSIN", joinColumns = {@JoinColumn(name = "EXTERNAL_DATA_IN_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PARAMSIN_ID", referencedColumnName = "ID")})
    private List<ExternalDataParam> paramsIN;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "EXTERNAL_DATA_PARAMSOUT", joinColumns = {@JoinColumn(name = "EXTERNAL_DATA_OUT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PARAMSOUT_ID", referencedColumnName = "ID")})
    private List<ExternalDataParam> paramsOUT;


    //Constructors
    public ExternalData() {
    }

    public ExternalData(String name, Date created, Long ownerGroupId, Long ownerUserId, List<ExternalDataParam> paramsIN, List<ExternalDataParam> paramsOUT) {
        this.name = name;
        this.created = created;
        this.ownerGroupId = ownerGroupId;
        this.ownerUserId = ownerUserId;
        this.paramsIN = paramsIN;
        this.paramsOUT = paramsOUT;
    }


    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getOwnerGroupId() {
        return ownerGroupId;
    }

    public void setOwnerGroupId(Long ownerGroupId) {
        this.ownerGroupId = ownerGroupId;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public List<ExternalDataParam> getParamsIN() {
        return paramsIN;
    }

    public void setParamsIN(List<ExternalDataParam> paramsIN) {
        this.paramsIN = paramsIN;
    }

    public List<ExternalDataParam> getParamsOUT() {
        return paramsOUT;
    }

    public void setParamsOUT(List<ExternalDataParam> paramsOUT) {
        this.paramsOUT = paramsOUT;
    }

    public String getRestMethod() {
        return restMethod;
    }

    public void setRestMethod(String restMethod) {
        this.restMethod = restMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExternalData{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", created=").append(created);
        sb.append(", ownerGroupId=").append(ownerGroupId);
        sb.append(", ownerUserId=").append(ownerUserId);
        sb.append(", paramsIN=").append(paramsIN);
        sb.append(", paramsOUT=").append(paramsOUT);
        sb.append('}');
        return sb.toString();
    }
}

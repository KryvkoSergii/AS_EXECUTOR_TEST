package ua.com.smiddle.agent_scripting.core.model.json.external_data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by srg on 23.05.16.
 */
public class ExternalDataRequest implements Serializable {
    @JsonProperty("id")
    private Long externalDataID;
    @JsonProperty("name")
    private String filteredName;
    @JsonProperty("dateFrom")
    private Date dateFrom;
    @JsonProperty("dateTo")
    private Date dateTo;
    @JsonProperty("creatorFName")
    private String creatorFirstName;
    @JsonProperty("creatorLName")
    private String creatorLastName;
    @JsonProperty("creatorPName")
    private String creatorPatronymicName;
    @JsonProperty("ownerGroupID")
    private Long ownerGroupID;


    //Constructors
    public ExternalDataRequest() {
    }

    public ExternalDataRequest(Long externalDataID, String filteredName, Date dateFrom, Date dateTo, String creatorFirstName, String creatorLastName, String creatorPatronymicName) {
        this.externalDataID = externalDataID;
        this.filteredName = filteredName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.creatorFirstName = creatorFirstName;
        this.creatorLastName = creatorLastName;
        this.creatorPatronymicName = creatorPatronymicName;
    }

    //Getters and setters
    public Long getExternalDataID() {
        return externalDataID;
    }

    public void setExternalDataID(Long externalDataID) {
        this.externalDataID = externalDataID;
    }

    public String getFilteredName() {
        return filteredName;
    }

    public void setFilteredName(String filteredName) {
        this.filteredName = filteredName;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getCreatorFirstName() {
        return creatorFirstName;
    }

    public void setCreatorFirstName(String creatorFirstName) {
        this.creatorFirstName = creatorFirstName;
    }

    public String getCreatorLastName() {
        return creatorLastName;
    }

    public void setCreatorLastName(String creatorLastName) {
        this.creatorLastName = creatorLastName;
    }

    public String getCreatorPatronymicName() {
        return creatorPatronymicName;
    }

    public void setCreatorPatronymicName(String creatorPatronymicName) {
        this.creatorPatronymicName = creatorPatronymicName;
    }

    public Long getOwnerGroupID() {
        return ownerGroupID;
    }

    public void setOwnerGroupID(Long ownerGroupID) {
        this.ownerGroupID = ownerGroupID;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExternalDataRequest{");
        sb.append("externalDataID=").append(externalDataID);
        sb.append(", filteredName='").append(filteredName).append('\'');
        sb.append(", dateFrom=").append(dateFrom);
        sb.append(", dateTo=").append(dateTo);
        sb.append(", creatorFirstName='").append(creatorFirstName).append('\'');
        sb.append(", creatorLastName='").append(creatorLastName).append('\'');
        sb.append(", creatorPatronymicName='").append(creatorPatronymicName).append('\'');
        sb.append(", ownerGroupID=").append(ownerGroupID);
        sb.append('}');
        return sb.toString();
    }
}

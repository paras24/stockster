package com.impetus.ee.vo;

import java.util.Date;

public class OpportunityInfo {
private int opportunityID;
private String projectName;
private String subProjectname;
private String pointOfContact;
private Date requestDate;
private int requirement;
private String location;
private Date startdate;
private int duration;
private String type;
private String status;

public int getOpportunityID() {
	return opportunityID;
}
public void setOpportunityID(int opportunityID) {
	this.opportunityID = opportunityID;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getSubProjectname() {
	return subProjectname;
}
public void setSubProjectname(String subProjectname) {
	this.subProjectname = subProjectname;
}
public String getPointOfContact() {
	return pointOfContact;
}
public void setPointOfContact(String pointOfContact) {
	this.pointOfContact = pointOfContact;
}
public Date getRequestDate() {
	return requestDate;
}
public void setRequestDate(Date requestDate) {
	this.requestDate = requestDate;
}
public int getRequirement() {
	return requirement;
}
public void setRequirement(int requirement) {
	this.requirement = requirement;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Date getStartdate() {
	return startdate;
}
public void setStartdate(Date startdate) {
	this.startdate = startdate;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}

package com.impetus.ee.domain.opportunity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.impetus.ee.domain.DomainObject;

@Entity
@Table(name="Opportunity")
public class Opportunity extends DomainObject {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="opportunityID")
private Integer opportunityID;
@Column(name="projectName")
private String projectName;
@Column(name="subprojectName")
private String subProjectName;
@Column(name="pointOfContact")
private String pointOfContact;
@Column(name="dateOfRequest")
private Date dateOfRequest;
@Column(name="numberOfRequiredPeople")
private Integer numberOfRequiredPeople;
@Column(name="location")
private String location;
@Column(name="startDateOfResources")
private Date startDateOfResources;
@Column(name="durationOfResources")
private Date durationOfResources;
@Column(name="requirementType")
private String requirementType;
@Column(name="requirementStatus")
private String requirementStatus;
@Column(name="skillset")
private String skillSet;
@Column(name="comments")
private String comments;
}

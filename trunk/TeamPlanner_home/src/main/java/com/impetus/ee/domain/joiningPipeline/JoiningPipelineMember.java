package com.impetus.ee.domain.joiningPipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="JoiningPipelineMembers")
public class JoiningPipelineMember {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jPmemberID")
	private Long jPmemberID;
	@Column(name="jPmemberName")
	private String jPmemberName;
	@Column(name="Grade")
	private String Grade;
	@Column(name="experience")
	private int experience;
	@Column(name="keySkills")
	private String keySkills; /*Initially considering a comma separated string values*/
	@Column(name="remarks")
	private String remarks;
	@Column(name="dateOfJoining")
	private Date dateOfJoining;
	@Column(name="supervisorName")
	private String supervisorName;
	@Column(name="status")
	private String status;
	
	public Long getjPMemberID() {
		return jPmemberID;
	}
	public void setjPMemberID(Long jPmemberID) {
		this.jPmemberID = jPmemberID;
	}
	public String getjPMemberName() {
		return jPmemberName;
	}
	public void setjPMemberName(String jPmemberName) {
		this.jPmemberName = jPmemberName;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getKeySkills() {
		return keySkills;
	}
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

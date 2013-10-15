package com.impetus.ee.domain.joiningPipeline;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.impetus.ee.domain.relation.ProjectJPMemberRelation;
import com.impetus.ee.domain.relation.ProjectMemberRelation;
@Entity
@Table(name="JoiningPipelineMembers")
public class JoiningPipelineMember {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jpmemberID")
	private int jpmemberID;
	@Column(name="jpmemberName")
	private String jpmemberName;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "relationKey.joiningPipelineMember", cascade=CascadeType.ALL)
	private Set<ProjectJPMemberRelation> projectJPMemberRelation = new HashSet<ProjectJPMemberRelation>(0);
	
	
	public int getJpmemberID() {
		return jpmemberID;
	}
	public void setJpmemberID(int jpmemberID) {
		this.jpmemberID = jpmemberID;
	}

	public String getJpmemberName() {
		return jpmemberName;
	}
	public void setJpmemberName(String jpmemberName) {
		this.jpmemberName = jpmemberName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<ProjectJPMemberRelation> getProjectJPMemberRelation() {
		return this.projectJPMemberRelation;
	}
	public void setProjectJPMemberRelation(Set<ProjectJPMemberRelation> projectJPMemberRelation) {
		this.projectJPMemberRelation = projectJPMemberRelation;
	}
	
}

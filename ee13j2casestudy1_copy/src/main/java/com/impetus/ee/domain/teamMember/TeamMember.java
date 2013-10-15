package com.impetus.ee.domain.teamMember;

import java.util.Date;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.impetus.ee.domain.relation.ProjectMemberRelation;
@Entity
@Table(name="TeamMembers")
public class TeamMember
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="memberID")
	private Long memberID;
	@Column(name="memberName")
	private String memberName;
	@Column(name="Grade")
	private String Grade;
	@Column(name="experirnce")
	private int experience;
	@Column(name="keySkills")
	private String keySkills; /*Initially consdering a comma seperated string values*/
	@Column(name="remarks")
	private String remarks;
	@Column(name="dateOfJoining")
	private Date dateOfJoining;
	@Column(name="groupHeadName")
	private String groupHeadName;
	@Column(name="status")
	private String status;
	@Column(name="supervisor")
	private String supervisor;
	
	
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "relationKey.teamMember", cascade=CascadeType.ALL)
	private Set<ProjectMemberRelation> projectMemberRelation = new HashSet<ProjectMemberRelation>(0);

	public Long getMemberID() {
		return memberID;
	}
	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public void setExperience(int experirnce) {
		this.experience = experirnce;
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
	public String getGroupHeadName() {
		return groupHeadName;
	}
	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Set<ProjectMemberRelation> getProjectMemberRelation() {
		return this.projectMemberRelation;
	}
	public void setProjectMemberRelation(Set<ProjectMemberRelation> projectMemberRelation) {
		this.projectMemberRelation = projectMemberRelation;
	}
	
	
}

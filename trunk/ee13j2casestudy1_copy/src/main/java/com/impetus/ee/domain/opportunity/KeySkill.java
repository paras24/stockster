package com.impetus.ee.domain.opportunity;

import com.impetus.ee.domain.relation.Entity;
import com.impetus.ee.domain.relation.Table;

@Entity
@Table(name = "keyskill")
class KeySkill {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Integer ID;
	
	@Column(name="skill")
	private String skill;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
}

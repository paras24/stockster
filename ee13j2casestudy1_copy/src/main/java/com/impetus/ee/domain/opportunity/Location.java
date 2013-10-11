package com.impetus.ee.domain.opportunity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Locations")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Loc_Id")
	private Integer id;
	
	@Column(name="Loc_Name")
	private String locName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", locName=" + locName + "]";
	}
	
	
}

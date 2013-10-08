package com.impetus.ee.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class DomainObject 
{
	private Date created;
	private Date modified;
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}
	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
}

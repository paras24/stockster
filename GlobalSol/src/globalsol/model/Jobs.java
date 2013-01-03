/**
 * 
 */
package globalsol.model;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Jobs.
 *
 * @author manoj.singh
 */
public class Jobs {

	/** The id. */
	private Integer id;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The details. */
	private String details;
	
	/** The date modified. */
	private Date dateModified;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	
	/**
	 * Sets the details.
	 *
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	
	/**
	 * Gets the date modified.
	 *
	 * @return the dateModified
	 */
	public Date getDateModified() {
		return dateModified;
	}
	
	/**
	 * Sets the date modified.
	 *
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

}

package dao;

/**
 * 
 */



import java.util.List;

import entity.Jobs;


// TODO: Auto-generated Javadoc
/**
 * The Interface JobsDAO.
 *
 * @author manoj.singh
 */
public interface JobsDAO {
	
	/**
	 * Gets the jobs.
	 *
	 * @param connection the connection
	 * @param request the request
	 * @param response the response
	 * @return the array list
	 */
	public List<Jobs> GetJobs();

	

}

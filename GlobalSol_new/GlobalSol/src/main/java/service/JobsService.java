package service;



import java.util.List;



import entity.Jobs;



/**
 * The Interface JobsService.
 *
 * @author manoj.singh
 */


public interface JobsService {	
	/**
	 * Gets the messages.
	 *
	 * @param connection the connection
	 * @param request the request
	 * @param response the response
	 * @return the array list
	 */
	public List<Jobs> GetMessages();
}

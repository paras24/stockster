package globalsol.service;

import globalsol.model.Jobs;

import java.util.ArrayList;


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
	public ArrayList<Jobs> GetMessages();
}

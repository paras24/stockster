/**
 * 
 */
package globalsol.serviceImpl;

import globalsol.dao.JobsDAO;
import globalsol.daoImpl.JobsDAOImpl;
import globalsol.model.Jobs;
import globalsol.service.JobsService;

import java.util.ArrayList;


/**
 * The Class JobsServiceImpl.
 *
 * @author manoj.singh
 */
public class JobsServiceImpl implements JobsService {

	/* (non-Javadoc)
	 * @see globalsol.service.JobsService#GetMessages(java.sql.Connection, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ArrayList<Jobs> GetMessages() {
		ArrayList<Jobs> jobsList = new ArrayList<Jobs>();
		try {
			// Here you can validate before connecting DAO class, eg. User session condition 
			JobsDAO dao = new JobsDAOImpl();
			jobsList=dao.GetJobs();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jobsList;	
	}

}

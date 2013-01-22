package serviceImpl;

/**
 * 
 */




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.JobsDAO;
import entity.Jobs;


import service.JobsService;


/**
 * The Class JobsServiceImpl.
 *
 * @author manoj.singh
 */

@Service
public class JobsServiceImpl implements JobsService {
	
	
	@Autowired
	private JobsDAO jobsDAO;
	
	public List<Jobs> GetMessages() {
		List<Jobs> jobsList = new ArrayList<Jobs>();
		try {
			jobsList=jobsDAO.GetJobs();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jobsList;	
	}
	
	/**
	 * @param jobsDAO the jobsDAO to set
	 */
	public void setJobsDAO(JobsDAO jobsDAO) {
		this.jobsDAO = jobsDAO;
	}

}

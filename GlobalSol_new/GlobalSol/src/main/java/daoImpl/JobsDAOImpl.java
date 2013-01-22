package daoImpl;

/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import dao.JobsDAO;
import entity.Jobs;

// TODO: Auto-generated Javadoc
/**
 * The Class JobsDAOImpl.
 *
 * @author manoj.singh
 */
@Repository
public class JobsDAOImpl implements JobsDAO{

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	} 
	
	@SuppressWarnings("unchecked")
	public List<Jobs> GetJobs(){
		List<Jobs> jobsList = new ArrayList<Jobs>();
		jobsList =(ArrayList<Jobs>) hibernateTemplate.find("from Jobs");
		System.out.println(jobsList.get(0).getTitle());
		return jobsList;
	}
}

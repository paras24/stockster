/**
 * 
 */
package globalsol.daoImpl;

import globalsol.dao.JobsDAO;
import globalsol.model.Jobs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class JobsDAOImpl.
 *
 * @author manoj.singh
 */
public class JobsDAOImpl implements JobsDAO{

	/* (non-Javadoc)
	 * @see globalsol.dao.JobsDAO#GetJobs(java.sql.Connection, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ArrayList<Jobs> GetJobs() {
		// TODO Auto-generated method stub
		ArrayList<Jobs> jobsList = new ArrayList<Jobs>();
		Connection conn = null;
		try
		{	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/globalsoldb","root","root");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM services");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Jobs jobs = new Jobs();
				jobs.setId(rs.getInt("id"));
				jobs.setTitle(rs.getString("title"));
				jobs.setDescription(rs.getString("description"));
				jobs.setDetails(rs.getString("details"));
				jobsList.add(jobs);
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return jobsList;

	}
	
	public static void main(String[] args) {
		new JobsDAOImpl().GetJobs();
	}
}

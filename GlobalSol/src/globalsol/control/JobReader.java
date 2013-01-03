package globalsol.control;

import globalsol.model.Jobs;
import globalsol.service.JobsService;
import globalsol.serviceImpl.JobsServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class JobReader
 */
@WebServlet("/JobReader")
public class JobReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobReader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{	
			JobsService service = new JobsServiceImpl();
			ArrayList<Jobs> jobsData = new ArrayList<Jobs>();
			jobsData = service.GetMessages();
			Gson gson = new Gson();
			String output = gson.toJson(jobsData);
			System.out.println(output);
			out.println("{\"Messages\":"+output+"}");
		}
		catch (Exception ex)
		{
			out.println("Error: " + ex.getMessage());
		}
		finally
		{
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}

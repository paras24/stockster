package globalsol.control;

import globalsol.model.Clients;
import globalsol.service.ClientsService;
import globalsol.serviceImpl.ClientsServiceImpl;

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
 * Servlet implementation class ClientReader
 */
@WebServlet("/ClientReader")
public class ClientReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientReader() {
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
			ClientsService service = new ClientsServiceImpl();
			ArrayList<Clients> clientsData = new ArrayList<Clients>();
			clientsData = service.GetMessages();
			Gson gson = new Gson();
			String output = gson.toJson(clientsData);
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

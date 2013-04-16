package djdad.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import djdad.util.DBaccess;

/**
 * Servlet implementation class TagWriter
 */
@WebServlet("/TagWriter")
public class TagWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TagWriter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("tag maker called");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		try
		{	
			conn = DBaccess.getConn();
			PreparedStatement pst = conn.prepareStatement("Insert into tags(project,word,url) values(?,?,?)");
			pst.setString(1, request.getParameter("project"));
			pst.setString(2, request.getParameter("word"));
			pst.setString(3, request.getParameter("url"));
			int i = pst.executeUpdate();
			System.out.println(i);
			out.write(String.valueOf(i));
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

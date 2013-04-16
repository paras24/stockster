package djdad.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import djdad.model.Tags;
import djdad.util.DBaccess;

/**
 * Servlet implementation class TagMaker
 */
@WebServlet("/TagMaker")
public class TagMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TagMaker() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		try
		{	
			conn = DBaccess.getConn();
			PreparedStatement pst = conn.prepareStatement("select * from tags where project=? and word=?");
			pst.setString(1,request.getParameter("project"));
			String string = request.getParameter("string");

			String[] strings = string.split("[\\p{Punct}\\s]+");
			HashSet< String> strset = new HashSet<String>();
			for (String string2 : strings) {
				strset.add(string2);
			}
			ArrayList<Tags> tagList = new ArrayList<Tags>();
			for (String string2 : strset) {
				pst.setString(2,string2);
				ResultSet rst = pst.executeQuery();

				while(rst.next()){
					Tags tag = new Tags();
					tag.setProject(request.getParameter("project"));
					tag.setWord(string2);
					tag.setUrl(rst.getString("url"));
					tagList.add(tag);

				}

			}

			Thread.sleep(300);
			Gson gson = new Gson();
			String output = gson.toJson(tagList);
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

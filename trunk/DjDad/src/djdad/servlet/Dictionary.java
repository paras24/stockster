package djdad.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import djdad.model.Tags;
import djdad.util.DBaccess;

/**
 * Servlet implementation class Dictionary
 */
@WebServlet("/Dictionary")
public class Dictionary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dictionary() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		ArrayList<Tags> tagList = new ArrayList<Tags>();
		try {
			conn = DBaccess.getConn();
			PreparedStatement pst = conn.prepareStatement("select * from tags where (project like ? or project like ?) and (word like ? or word like ?)");
			String project = request.getParameter("project");
			String word = request.getParameter("word");
			pst.setString(1, "% "+project+"%");
			pst.setString(2, project+"%");
			pst.setString(3, "% "+word+"%");
			pst.setString(4, word+"%");
			System.out.println(pst.toString());

			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				Tags tag = new Tags();
				tag.setProject(rst.getString("project"));
				tag.setWord(rst.getString("word"));
				tag.setUrl(rst.getString("url"));
				tagList.add(tag);
			}

			Gson gson = new Gson();
			String output = gson.toJson(tagList);
			System.out.println("{\"Messages\":" + output + "}");
			out.println("{\"Messages\":" + output + "}");

		} catch (Exception ex) {
			out.println("Error: " + ex.getMessage());
		} finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}

package globalsol.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import globalsol.dao.ClientsDAO;
import globalsol.model.Clients;


public class ClientsDAOImpl implements ClientsDAO{

	@Override
	public ArrayList<Clients> GetClients() {
		ArrayList<Clients> clientsList = new ArrayList<Clients>();
		Connection conn = null;
		try
		{	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/globalsoldb","root","root");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Clients clients = new Clients();
				clients.setId(rs.getInt("id"));
				clients.setName(rs.getString("name"));
				clients.setDescription(rs.getString("description"));
				clients.setDetails(rs.getString("details"));
				clientsList.add(clients);
				System.out.println("printin data @ JsonDAOImpl "+clients.getName());
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return clientsList;
	}

}

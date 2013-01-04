package globalsol.serviceImpl;

import globalsol.dao.ClientsDAO;
import globalsol.daoImpl.ClientsDAOImpl;
import globalsol.model.Clients;
import globalsol.service.ClientsService;

import java.util.ArrayList;

public class ClientsServiceImpl implements ClientsService{

	@Override
	public ArrayList<Clients> GetMessages() {
		ArrayList<Clients> clientsList = new ArrayList<Clients>();
		try {
			// Here you can validate before connecting DAO class, eg. User session condition 
			ClientsDAO clientsdao = new ClientsDAOImpl();
			clientsList=clientsdao.GetClients();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return clientsList;
	}

}

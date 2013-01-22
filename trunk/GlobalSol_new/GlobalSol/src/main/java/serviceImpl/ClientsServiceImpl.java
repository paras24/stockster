package serviceImpl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.ClientsDAO;
import entity.Clients;


import service.ClientsService;
@Service
public class ClientsServiceImpl implements ClientsService{
	
	@Autowired
	private ClientsDAO clientsDAO;
	
	public void setClientsDAO(ClientsDAO clientsDAO) {
		this.clientsDAO = clientsDAO;
	}

	public List<Clients> GetMessages() {
		List<Clients> clientsList = new ArrayList<Clients>();
		try {	
			clientsList=clientsDAO.GetClients();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return clientsList;
	}

}

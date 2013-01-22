package daoImpl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import dao.ClientsDAO;
import entity.Clients;



@Repository
public class ClientsDAOImpl implements ClientsDAO{
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@SuppressWarnings("unchecked")
	public List<Clients> GetClients() {
		List<Clients> clientsList = new ArrayList<Clients>();
		clientsList= hibernateTemplate.find("from Clients");
		System.out.println(clientsList.get(0).getName());
		return clientsList;
	}

}

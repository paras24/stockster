package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ClientsService;

import com.google.gson.Gson;


import entity.Clients;



@Controller
public class ClientController {
	
	
	@Autowired
	private ClientsService clientsService ;
	
	
	
	@RequestMapping(value="/ClientReader", method=RequestMethod.GET)
	public @ResponseBody String getClients(){
	List<Clients> clientsData = new ArrayList<Clients>();
	clientsData = clientsService.GetMessages();
	Gson gson = new Gson();
	String output = gson.toJson(clientsData);
	output= "{\"Messages\":"+output+"}";
	System.out.println(output);
	return output;
	}

	/**
	 * @param clientsService the clientsService to set
	 */
	public void setClientsService(ClientsService clientsService) {
		this.clientsService = clientsService;
	}
}




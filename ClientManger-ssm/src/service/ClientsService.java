package service;

import java.util.List;

import entity.Client;

public interface ClientsService {
	public List findAll(int first,int last);
	public int addClient(Client client);
	public int findCount();
	public Client findClientById(String id);
	public int updateClientAssgin(Client client);
	public int updateClient(Client client);
	public List findClientType();
	public Client findClientSatisfaction(String id);
	public int addClientSatisfaction(Client client);
	public int deleteClientSatisfaction(String clientId);
	public List findAllOrder(String name);
}

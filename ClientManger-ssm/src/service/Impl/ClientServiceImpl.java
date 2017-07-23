package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.ClientGoodsIdMapper;
import mapper.ClientMapper;

import org.springframework.stereotype.Service;

import entity.Client;

import service.ClientsService;
@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientsService {
	@Resource(name = "clientMapper")
	ClientMapper clientMapper=null;

	public ClientMapper getClientMapper() {
		return clientMapper;
	}

	public void setClientMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}
	@Resource(name ="clientGoodsIdMapper")
	ClientGoodsIdMapper clientGoodsIdMapper=null;
	
 

 

	public void setClientGoodsIdMapper(ClientGoodsIdMapper clientGoodIdMapper) {
		this.clientGoodsIdMapper = clientGoodIdMapper;
	}

	public int addClient(Client client) {
		// TODO Auto-generated method stub
		return clientMapper.addClient(client);
	}

	public List findAll(int first, int last) {
		// TODO Auto-generated method stub
		return clientMapper.findAll(first, last);
	}

	public int findCount() {
		// TODO Auto-generated method stub
		return clientMapper.findCount();
	}

	public Client findClientById(String id) {
		// TODO Auto-generated method stub
		return clientMapper.findClientById(id);
	}

	public int updateClientAssgin(Client client) {
		// TODO Auto-generated method stub
		return clientMapper.updateClientAssgin(client);
	}

	public int updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientMapper.updateClient(client);
	}

	public List findClientType() {
		// TODO Auto-generated method stub
		return clientMapper.findClientType();
	}

	public Client findClientSatisfaction(String id) {
		// TODO Auto-generated method stub
		return clientMapper.findClientSatisfaction(id);
	}

	public int addClientSatisfaction(Client client) {
		// TODO Auto-generated method stub
		return clientMapper.addClientSatisfaction(client);
	}

	public int deleteClientSatisfaction(String clientId) {
		// TODO Auto-generated method stub
		return clientMapper.deleteClientSatisfaction(clientId);
	}

	public List findAllOrder(String name) {
		// TODO Auto-generated method stub
	
		List findAllOrder = clientGoodsIdMapper.findAllOrder(name);
		
		return findAllOrder;
	}

 

 

 
 
 
	
}

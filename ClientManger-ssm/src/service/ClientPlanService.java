package service;

import java.util.List;

import entity.ClientPlan;

public interface ClientPlanService {
	public int addClientPlan(ClientPlan clientplan);
	public List allClientPlan(int first,int last);
	public ClientPlan findById(String id);
	public int findCount();
	public int updateClientPlan(ClientPlan clientPlan);
	public int deleteClientPlan(String id);
	 
}

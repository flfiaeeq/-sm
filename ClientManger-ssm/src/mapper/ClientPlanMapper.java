package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.ClientPlan;

public interface ClientPlanMapper {
	public int addClientPlan(ClientPlan clientplan);
	public List allClientPlan(int first,int last);
	public ClientPlan findById(String id);
	public int findCount();
	public int updateClientPlan(ClientPlan clientPlan);
	public int deleteClientPlan(String id);
}

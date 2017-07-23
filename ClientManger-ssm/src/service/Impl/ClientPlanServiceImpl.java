package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.ClientPlanMapper;

import org.springframework.stereotype.Service;

import entity.ClientPlan;
import service.ClientPlanService;
@Service("ClientPlanServiceImpl")
public class ClientPlanServiceImpl implements ClientPlanService {
	@Resource(name = "clientPlanMapper")
	ClientPlanMapper clientPlanMapper=null;
	
	public void setClientPlanMapper(ClientPlanMapper clientPlanMapper) {
		this.clientPlanMapper = clientPlanMapper;
	}

	public int addClientPlan(ClientPlan clientplan) {
		// TODO Auto-generated method stub
		return clientPlanMapper.addClientPlan(clientplan);
	}

	public List allClientPlan(int first,int last) {
		// TODO Auto-generated method stub
		return clientPlanMapper.allClientPlan(first, last);
	}

	public ClientPlan findById(String id) {
		// TODO Auto-generated method stub
		return clientPlanMapper.findById(id);
	}

	public int findCount() {
		// TODO Auto-generated method stub
		return clientPlanMapper.findCount();
	}

	public int updateClientPlan(ClientPlan clientPlan) {
		// TODO Auto-generated method stub
		return clientPlanMapper.updateClientPlan(clientPlan);
	}

	public int deleteClientPlan(String id) {
		// TODO Auto-generated method stub
		return clientPlanMapper.deleteClientPlan(id);
	}

 

 

 

}

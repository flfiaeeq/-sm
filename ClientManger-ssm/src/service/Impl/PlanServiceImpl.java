package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.EmpMapper;
import mapper.PlanMapper;

import org.springframework.stereotype.Service;

import entity.Plan;

import service.PlanService;

@Service("planServiceImpl")
public class PlanServiceImpl implements PlanService {
	@Resource(name = "planMapper")
	private PlanMapper planMapper = null;
	public List findAllPlan() {
		// TODO Auto-generated method stub
		return planMapper.findAllPlan();
	}

	public PlanMapper getPlanMapper() {
		return planMapper;
	}

	public void setPlanMapper(PlanMapper planMapper) {
		this.planMapper = planMapper;
	}
    
	
	public int insertPlan(Plan plan) {
		// TODO Auto-generated method stub
		return planMapper.insertPlan(plan);
	}

	public int deletePlan(String arg0) {
		// TODO Auto-generated method stub
		return planMapper.deletePlan(arg0);
	}

	public Plan findByIdPlan(String planid) {
		// TODO Auto-generated method stub
		List findByIdPlan = planMapper.findByIdPlan(planid);
		if(findByIdPlan.size()>0){
			return (Plan) findByIdPlan.get(0);
		}
		return null;
	}

	public int updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		return planMapper.updatePlan(plan);
	}


	public int findcount(String name) {
		// TODO Auto-generated method stub
		return planMapper.findcount(name);
	}

	public int updatePlanState(Plan plan) {
		// TODO Auto-generated method stub
		return planMapper.updatePlanState(plan);
	}

	public List findByPageStatePlan(String name,int first, int last) {
		// TODO Auto-generated method stub
		return planMapper.findByPageStatePlan(name,first,last);
	}


	
}

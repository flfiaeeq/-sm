package mapper;

import java.util.List;

import entity.Plan;

public interface PlanMapper {
	public List findAllPlan();

	public int insertPlan(Plan plan);

	public int deletePlan(String planid);

	public List findByIdPlan(String planid);

	public int updatePlan(Plan plan);

	public List findByPageStatePlan(String name,int first, int last);
	public int findcount(String name);
	
	public int updatePlanState(Plan plan);
}

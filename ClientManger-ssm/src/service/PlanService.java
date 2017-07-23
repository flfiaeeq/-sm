package service;

import java.util.List;

import entity.Plan;

public interface PlanService {
	public List findAllPlan();
	public int insertPlan(Plan plan);
	public int deletePlan(String planid);
	public Plan findByIdPlan(String planid);
	public int updatePlan(Plan plan);
	public int findcount(String name);
	public int updatePlanState(Plan plan);
	public List findByPageStatePlan(String name,int first, int last);
	
}

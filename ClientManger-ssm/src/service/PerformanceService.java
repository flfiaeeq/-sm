package service;

import java.util.List;

import entity.Performance;
import entity.Prediction;

public interface PerformanceService {
	public List findAllPerformance(int first,int last);
	public int findcountPerfor();
	public Performance findByIdPerformance(String id);
	public int insertPerformance(Performance performance);
	public int deletePerformance(String id);
	public int updatePerformance(Performance performance);
}

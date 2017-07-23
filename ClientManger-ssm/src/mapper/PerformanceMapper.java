package mapper;

import java.util.List;

import entity.Performance;
import entity.Prediction;

public interface PerformanceMapper {
	public List findAllPerformance(int first,int last);
	public int findcountPerfor();
	public List findByIdPerformance(String id);
	public int insertPerformance(Performance performance);
	public int deletePerformance(String id);
	public int updatePerformance(Performance performance);
}

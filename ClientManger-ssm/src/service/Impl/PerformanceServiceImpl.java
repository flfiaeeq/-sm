package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.PerformanceMapper;

import org.springframework.stereotype.Service;

import service.PerformanceService;
import entity.Performance;

@Service("performanceServiceImpl")
public class PerformanceServiceImpl implements PerformanceService {
	@Resource(name = "performanceMapper")
	private PerformanceMapper performanceMapper = null;

	public PerformanceMapper getPerformanceMapper() {
		return performanceMapper;
	}

	public void setPerformanceMapper(PerformanceMapper performanceMapper) {
		this.performanceMapper = performanceMapper;
	}

	public List findAllPerformance(int first, int last) {
		// TODO Auto-generated method stub
		return performanceMapper.findAllPerformance(first, last);
	}

	public int findcountPerfor() {
		// TODO Auto-generated method stub
		return performanceMapper.findcountPerfor();
	}

	public Performance findByIdPerformance(String id) {
		// TODO Auto-generated method stub
		List findByIdPerformance = performanceMapper.findByIdPerformance(id);
		if (findByIdPerformance.size() != 0) {
			return (Performance) findByIdPerformance.get(0);
		}
		return null;
	}

	public int insertPerformance(Performance performance) {
		// TODO Auto-generated method stub
		return performanceMapper.insertPerformance(performance);
	}

	public int deletePerformance(String id) {
		// TODO Auto-generated method stub
		return performanceMapper.deletePerformance(id);
	}

	public int updatePerformance(Performance performance) {
		// TODO Auto-generated method stub
		return performanceMapper.updatePerformance(performance);
	}

}

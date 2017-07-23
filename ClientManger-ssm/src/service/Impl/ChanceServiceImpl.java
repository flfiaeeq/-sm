package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.ChanceMapper;

import org.springframework.stereotype.Service;

import entity.Chance;

import service.ChanceService;

@Service("chanceServiceImpl")
public class ChanceServiceImpl implements ChanceService {
	@Resource(name = "chanceMapper")
	private ChanceMapper chanceMapper = null;

	public ChanceMapper getChanceMapper() {
		return chanceMapper;
	}

	public void setChanceMapper(ChanceMapper chanceMapper) {
		this.chanceMapper = chanceMapper;
	}

	public List findAllChance(int first, int last) {
		// TODO Auto-generated method stub
		return chanceMapper.findAllChance(first, last);
	}

	public int findcountChance() {
		// TODO Auto-generated method stub
		return chanceMapper.findcountChance();
	}

	public int deleteChance(String id) {
		// TODO Auto-generated method stub
		return chanceMapper.deleteChance(id);
	}

	public int insertChance(Chance chance) {
		// TODO Auto-generated method stub
		return chanceMapper.insertChance(chance);
	}

	public int updateChance(Chance chance) {
		// TODO Auto-generated method stub
		return chanceMapper.updateChance(chance);
	}

	public int updateChanceControl(Chance chance) {
		// TODO Auto-generated method stub
		
		return chanceMapper.updateChanceControl(chance);
	}

	public Chance findByIdChance(String id) {
		List findByIdChance = chanceMapper.findByIdChance(id);
		if(findByIdChance.size()!=0){
		return  (Chance) findByIdChance.get(0);
		}
		return null;
	}

}

package service;

import java.util.List;

import entity.Chance;

public interface ChanceService {
	public List findAllChance(int first,int last);
	public int findcountChance();
	
	public int updateChance(Chance chance);

	public int insertChance(Chance chance);

	public int updateChanceControl(Chance chance);

	public int deleteChance(String id);
	
	public Chance findByIdChance(String id);
}

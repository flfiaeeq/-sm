package service;

import java.util.List;

import entity.Dept;

public interface DeptService {
	public List findAllDeptEmpt(String deptname);
	public List findAllDept();
	
//	lei
	public Dept findDept(String deptId);
	public List findDeptFather();
	
	public List findDeptShortName();
	
	public int save(Dept dept);
	public int delete(String deptId);
	public int update(Dept dept);
}

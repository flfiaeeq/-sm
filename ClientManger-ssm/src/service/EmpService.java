package service;

import java.util.List;

import entity.Emp;

public interface EmpService {
	public List findAllEmp();
	public Emp findLogin(Emp emp);
	public List findByRoleEmp(String role);
	public List findEmpRole();
	
//	lei
	public Emp findEmp(String empId);
	public int save(Emp emp);
	public int delete(String empId);
	public int update(Emp emp);
	public String findEmp2(Emp emp);
}

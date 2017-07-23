package mapper;

import java.util.List;

import entity.Emp;

public interface EmpMapper {
	public List findAllEmp();
	public List findLogin(Emp emp);
	public List findByRoleEmp(String role);
	public List findEmpRole();
	             
	
//	lei
	public Emp findEmp(String empId);
	public Emp findEmp2(Emp emp);
	public int save(Emp emp);
	public int delete(String empId);
	public int update(Emp emp);
}

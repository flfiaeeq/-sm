package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.EmpMapper;
import mapper.RoleMapper;

import org.springframework.stereotype.Service;

import service.EmpService;
import entity.Emp;
import entity.Role;

@Service("empServiceImpl")
public class EmpServiceImpl implements EmpService {
	@Resource(name = "empMapper")
	private EmpMapper empMapper = null;
	private RoleMapper roleMapper ;
	
	   @Resource(name="roleMapper")
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	public EmpMapper getEmpMapper() {
		return empMapper;
	}
	public void setEmpMapper(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	public List findAllEmp() {
		// TODO Auto-generated method stub
		return empMapper.findAllEmp();
	}

	public Emp findLogin(Emp emp) {
		// TODO Auto-generated method stub
		List list = empMapper.findLogin(emp);
		if(list.size()>0){
		return (Emp) list.get(0);
		}
		return null;
	}

	public List findByRoleEmp(String role) {
		// TODO Auto-generated method stub
		return empMapper.findByRoleEmp(role);
	}
	public List findEmpRole() {
		// TODO Auto-generated method stub
		return empMapper.findEmpRole();
	}
	public int delete(String empId) {
		// TODO Auto-generated method stub
		return empMapper.delete(empId);
	}

	public Emp findEmp(String empId) {
		// TODO Auto-generated method stub
		return empMapper.findEmp(empId);
	}

	public int save(Emp emp) {
		// TODO Auto-generated method stub
		return empMapper.save(emp);
	}

	public int update(Emp emp) {
		// TODO Auto-generated method stub
		return empMapper.update(emp);
	}

	public String findEmp2(Emp emp) {
//		Emp findEmp2 = empMapper.findEmp2(emp);
		System.out.println(emp.getEmpRole());
		Role role = new Role();
		role.setRoleName(emp.getEmpRole().trim());
		Role findRoleId = roleMapper.findRoleId(role);
		return findRoleId.getRoleId();
//		return null;
	}

	
}

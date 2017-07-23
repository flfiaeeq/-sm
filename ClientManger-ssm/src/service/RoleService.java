package service;

import java.util.List;

import entity.Emp;
import entity.Role;

public interface RoleService {
	public List findAllRole();
	public List findRoleDept();
	public List findRoleName();
	public Role findById(String id);
	public int save(Role role);
	public int delete(String id);
	public int update(Role role);
	
	public List findQuanXian(Role role);
	
	public Role findRoleId(Role role);
}

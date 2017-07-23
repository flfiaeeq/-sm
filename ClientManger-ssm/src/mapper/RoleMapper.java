package mapper;

import java.util.List;

import entity.Emp;
import entity.Role;

public interface RoleMapper {
	public List findAllRole();
	public List findRoleDept();
	public List findRoleName();
	public Role findById(String id);
	
	//
	public Role findRoleId(Role role);
	
	public int save(Role role);
	public int delete(String id);
	public int update(Role role);
	
	
}

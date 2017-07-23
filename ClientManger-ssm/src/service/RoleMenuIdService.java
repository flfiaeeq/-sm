package service;

import entity.RoleMenuId;

public interface RoleMenuIdService {
	
	public int save(RoleMenuId roleMenuId);
	public int saves(String roleId,String[] menuIds);
}

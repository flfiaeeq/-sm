package service.Impl;

import javax.annotation.Resource;

import mapper.RoleMenuIdMapper;

import org.springframework.stereotype.Service;

import service.RoleMenuIdService;

import entity.RoleMenuId;

@Service
public class RoleMenuIdServiceImpl implements RoleMenuIdService {
	
	@Resource(name="roleMenuIdMapper")
	private RoleMenuIdMapper roleMenuIdMapper;
	
	public void setRoleMenuIdMapper(RoleMenuIdMapper roleMenuIdMapper) {
		this.roleMenuIdMapper = roleMenuIdMapper;
	}

	public int save(RoleMenuId roleMenuId) {
		// TODO Auto-generated method stub
		return roleMenuIdMapper.save(roleMenuId);
	}

	public int saves(String roleId, String[] menuIds) {
		if (menuIds==null) {
			return 0;
		}
		for (int i = 0; i < menuIds.length; i++) {
			RoleMenuId roleMenuId =new RoleMenuId(roleId, menuIds[i]);
			save(roleMenuId);
		}
		return 1;
	}

}

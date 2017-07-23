package mapper;

import java.util.List;

import entity.RoleMenuId;

public interface RoleMenuIdMapper {
	public List findMenuId(String roleId);
	public int save(RoleMenuId roleMenuId);
}

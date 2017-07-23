package service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.MenuMapper;
import mapper.RoleMapper;
import mapper.RoleMenuIdMapper;

import org.springframework.stereotype.Service;

import service.RoleService;
import entity.Emp;
import entity.FuZi;
import entity.Menu;
import entity.Role;
import entity.RoleMenuId;
@Service
public class RoleServiceImpl implements RoleService {
	private RoleMapper roleMapper ;
	private RoleMenuIdMapper roleMenuIdMapper;
	private MenuMapper menuMapper;
	

	@Resource(name = "roleMenuIdMapper")
	public void setRoleMenuIdMapper(RoleMenuIdMapper roleMenuIdMapper) {
		this.roleMenuIdMapper = roleMenuIdMapper;
	}
	

	@Resource(name = "roleMapper")
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Resource(name="menuMapper")
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}
	public List findAllRole() {
		// TODO Auto-generated method stub
		return roleMapper.findAllRole();
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return roleMapper.delete(id);
	}

	public Role findById(String id) {
		// TODO Auto-generated method stub
		return roleMapper.findById(id);
	}

	public int save(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.save(role);
	}

	public int update(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.update(role);
	}

	public List findRoleDept() {
		// TODO Auto-generated method stub
		return roleMapper.findRoleDept();
	}

	public List findRoleName() {
		// TODO Auto-generated method stub
		return roleMapper.findRoleName();
	}
	
	public List findQuanXian(Role role){
		ArrayList zong=new ArrayList();
		
		HashSet<String> h=new  HashSet<String>();
		List findMenuId = roleMenuIdMapper.findMenuId(role.getRoleId());
		//�������
		ArrayList zi=new ArrayList();
		
		for (int i = 0; i < findMenuId.size(); i++) {
			RoleMenuId rm=(RoleMenuId)findMenuId.get(i);
			Menu findMenu = menuMapper.findMenu(rm.getMenuId());
			if (findMenu==null) {
				continue;
			}
			zi.add(findMenu);
			String menuFather = findMenu.getMenuFather();
			h.add(menuFather);
		}
		//����
		zong.add(zi);
		
		
		//����ȫ���ĸ��Ӽ���
		ArrayList fanhui=new ArrayList();
		for (String menuFather : h) {
			FuZi fuZi = new FuZi();
			fuZi.setMenuFather(menuFather);
			List findZi = menuMapper.findZi(menuFather);
			fuZi.setMenuNames(findZi);
			fanhui.add(fuZi);
		}
		zong.add(fanhui);
		System.out.println("ȫ����Ȩ��"+zong);
		return zong;
	}


	public Role findRoleId(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleId(role);
	}

	
}

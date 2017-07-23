package service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mapper.MenuMapper;

import org.springframework.stereotype.Service;

import service.MenuService;
import entity.FuZi;
import entity.Menu;
@Service
public class MenuServiceImpl implements MenuService {
	private MenuMapper menuMapper;
	@Resource(name="menuMapper")
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return menuMapper.delete(id);
	}

	public List findAllMenu() {
		// TODO Auto-generated method stub
		return menuMapper.findAllMenu();
	}

	public Menu findMenu(String menuId) {
		// TODO Auto-generated method stub
		return menuMapper.findMenu(menuId);
	}

	public int save(Menu menu) {
		// TODO Auto-generated method stub
		return menuMapper.save(menu);
	}

	public int update(Menu menu) {
		// TODO Auto-generated method stub
		return menuMapper.update(menu);
	}

	public List findMenuFather() {
		// TODO Auto-generated method stub
		return menuMapper.findMenuFather();
	}

	//查出所有的父子关系

	public List findZi() {
		// TODO Auto-generated method stub
		ArrayList fanhui=new ArrayList();
		List findMenuFather = menuMapper.findMenuFather();
		for (int i = 0; i < findMenuFather.size(); i++) {
			FuZi fuZi = new FuZi();
			Menu mm=(Menu)findMenuFather.get(i);
			String menuFather = mm.getMenuFather();
			fuZi.setMenuFather(menuFather);
			List findZi = menuMapper.findZi(menuFather);
			fuZi.setMenuNames(findZi);
			fanhui.add(fuZi);
		}
		return fanhui;
	}

	public List count() {
		// TODO Auto-generated method stub
		 List count = menuMapper.count();
		return count;
	}
}

package service;

import java.util.List;

import entity.Menu;

public interface MenuService {

	public List findAllMenu();
	public List findMenuFather();
//	public List findFuZi(String menuFather);
	public List findZi();
	public Menu findMenu(String menuId);
	public int save(Menu menu);
	public int delete(String id);
	public int update(Menu menu);

	public List count();
}

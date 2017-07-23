package mapper;

import java.util.List;

import entity.Menu;

public interface MenuMapper {
	public List findAllMenu();
	public List findMenuFather();
	
	public List findZi(String menuFather);
	
	public Menu findMenu(String menuId);
	
	public int save(Menu menu);
	public int delete(String menuId);
	public int update(Menu menu);

	public List count();
	
}

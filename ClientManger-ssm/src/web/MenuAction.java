package web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MenuService;
import entity.Menu;

@Controller
public class MenuAction {
	private MenuService menuService;
	java.sql.Date time = new java.sql.Date(System.currentTimeMillis());

	@Resource(name = "menuServiceImpl")
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@RequestMapping("findAllMenu.do")
	public String findAll(Model model, HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {
		List findAllMenu = menuService.findAllMenu();
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		HttpSession session = request.getSession();

		session.setAttribute("findAllMenu", findAllMenu);

		return "forward:findFuZi.do";

	}

	@RequestMapping("findMenu.do")
	public String findMenu(String menuId, String flag, Model model,
			HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {
		Menu findMenu = menuService.findMenu(menuId);
		// model.addAttribute("findMenu", findMenu);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		HttpSession session = request.getSession();

		session.setAttribute("findMenu", findMenu);
		if (flag != null && flag.equals("updateMenu")) {
			try {
				request.getRequestDispatcher("findMenuFather.do").forward(
						request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return "admin/resource/sys/menu/view";

	}

	@RequestMapping("findMenuFather.do")
	public String findMenuFather(Model model, String flag) {
		List findMenuFather = menuService.findMenuFather();
		model.addAttribute("findMenuFather", findMenuFather);
		if (flag != null && flag.equals("updateMenu")) {

			return "admin/resource/sys/menu/edit";
		}
		return "admin/resource/sys/menu/add";

	}

	@RequestMapping("addMenu.do")
	public String add(Menu findMenu, Model model) {
		int save = menuService.save(findMenu);
		model.addAttribute("findMenu", findMenu);
		return "admin\\resource\\sys\\menu\\view";
	}

	@RequestMapping("deleteMenu.do")
	public String delete(String menuId, HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {

		int delete = menuService.delete(menuId);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		try {
			request.getRequestDispatcher("findAllMenu.do").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("updateMenu.do")
	public String update(Menu menu, String flag, Model model,
			HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {

		Menu findMenu = menuService.findMenu(menu.getMenuId());
		findMenu.setMenuUpdateTime(time);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;

		if (flag != null && flag.equals("updateMenu")) {
			findMenu.setMenuName(menu.getMenuName());
			findMenu.setMenuState(menu.getMenuState());
			findMenu.setMenuUrl(menu.getMenuUrl());
			findMenu.setMenuRemark(menu.getMenuRemark());
			menuService.update(findMenu);
			model.addAttribute("findMenu", findMenu);
			return "admin\\resource\\sys\\menu\\result";

		}

		// ����
		findMenu.setMenuState(menu.getMenuState());
		int update = menuService.update(findMenu);
		try {
			request.getRequestDispatcher("findAllMenu.do").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// �˵����Ӽ���
	@RequestMapping("findFuZi.do")
	public String findFuZi(Model model, String flag) {
		List findFuZi = menuService.findZi();
		model.addAttribute("findFuZi", findFuZi);
		// ��ɫ��Ȩ
		if (flag != null && flag.equals("shouquan")) {
			return "admin\\resource\\sys\\role\\role_authorise";
		}
		if (flag != null && flag.equals("index")) {
			return "admin\\index";
		}
		System.out.println("menu------");
		return "admin/resource/sys/menu/list";
	}
}


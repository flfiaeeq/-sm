package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.RoleMenuIdService;
import service.RoleService;
import entity.Role;
import entity.RoleMenuId;

@Controller
public class RoleAction {
	private RoleService roleService;
	private RoleMenuIdService roleMenuIdService;
	java.sql.Date time = new java.sql.Date(System.currentTimeMillis());
	
	

	@Resource(name = "roleMenuIdServiceImpl")
	public void setRoleMenuIdService(RoleMenuIdService roleMenuIdService) {
		this.roleMenuIdService = roleMenuIdService;
	}
	
	@Resource(name = "roleServiceImpl")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	

	@RequestMapping("findAllRole.do")
	public String findAll(Model model,String flag){
		List findAllRole = roleService.findAllRole();
		model.addAttribute("findAllRole", findAllRole);
		
		//Ա����Ȩ
		if (flag!=null&&flag.equals("shouquan")) {
			return "admin\\resource\\sys\\employee\\emp_authorise";
		}
		
		return "admin/resource/sys/role/list";
		
	}
	
	@RequestMapping("findRoleName.do")
	public String findRoleName(Model model,String flag,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse){
		List findRoleName = roleService.findRoleName();
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		HttpSession session = request.getSession();
		
		session.setAttribute("findRoleName", findRoleName);
		
		//��ɫ��Ȩ
		if (flag!=null&&flag.equals("shouquan")) {
			return "forward:findFuZi.do";
		}
		return "";
	}
	
	
	@RequestMapping("findRole.do")
	public String findRole(String roleId,String flag,Model model,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse){
		Role findRole = roleService.findById(roleId);
		
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		HttpSession session = request.getSession();
		
		session.setAttribute("findRole", findRole);
		if (flag!=null&&flag.equals("updateRole")) {
			try {
				request.getRequestDispatcher("findRoleDept.do").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if (flag!=null&&flag.equals("shouquan")) {
			try {
				request.getRequestDispatcher("findRoleName.do").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return "admin/resource/sys/role/view";
		
	}
	
	@RequestMapping("findRoleDept.do")
	public String findMenuFather(Model model,String flag){
		List findRoleDept = roleService.findRoleDept();
		model.addAttribute("findRoleDept", findRoleDept);
		if (flag!=null&&flag.equals("updateRole")) {
				
			return "admin/resource/sys/role/edit";
			}
		return "admin/resource/sys/role/add";
		
	}
	
	
	
	@RequestMapping("addRole.do")
	public String add(Role findRole,Model model){
		int save = roleService.save(findRole);
		model.addAttribute("findRole", findRole);
		return "admin\\resource\\sys\\role\\view";
	}
	
	@RequestMapping("deleteRole.do")
	public String delete(String roleId,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse){
		System.out.println("eeeeeee");
		int delete = roleService.delete(roleId);
		System.out.println("aaaa");
		
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		try {
			request.getRequestDispatcher("findAllRole.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("uuuuuuuuuu");
		return null;
	}
	
	@RequestMapping("updateRole.do")
	public String update(Role role,String flag,Model model,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse, RoleMenuId roleMenuId){
		
		Role findRole = roleService.findById(role.getRoleId());
		findRole.setRoleUpdateTime(time);
		
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		
		if (flag!=null&&flag.equals("updateRole")) {
			findRole.setRoleName(role.getRoleName());
			findRole.setRoleState(role.getRoleState());
			findRole.setRoleDept(role.getRoleDept());
			findRole.setRoleRemark(role.getRoleRemark());
			roleService.update(findRole);
			model.addAttribute("findRole", findRole);
			return "admin\\resource\\sys\\role\\result";
				
			}
		
	

		//����
		findRole.setRoleState(role.getRoleState());
		int update = roleService.update(findRole);
		try {
					request.getRequestDispatcher("findAllRole.do").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return null;
	}
	
	@RequestMapping("shouQuan.do")
	public String shouQuan(Role role,Model model,String[] menuIds){
		//��ɫ��Ȩ
		Role findRole = roleService.findById(role.getRoleId());
		findRole.setRoleUpdateTime(time);
		findRole.setRoleName(role.getRoleName());
		int update = roleService.update(findRole);
		model.addAttribute("findRole", findRole);
		//������ű�д��id
		roleMenuIdService.saves(role.getRoleId(),menuIds);
		return "admin\\resource\\sys\\role\\result";
		}
	
	@RequestMapping("tree.do")
	public String tree(Role role,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse){
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		HttpSession session = request.getSession();
		//
		List fq = (ArrayList)roleService.findQuanXian(role);
		session.setAttribute("zi",fq.get(0));
		session.setAttribute("fuziji",fq.get(1));
		return "admin\\index";
//		return null;
	}
}

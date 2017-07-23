package web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.DeptService;
import entity.Dept;

@Controller
public class DeptAction {
	java.sql.Date time = new java.sql.Date(System.currentTimeMillis());
	@Resource(name = "deptServiceImpl")
	private DeptService deptService = null;

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@RequestMapping("findAllDeptEmpt.do")
	public ModelAndView findAllDeptEmpt(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("flagd");
		String parameter1 = arg0.getParameter("deptll");
		parameter1=new String(parameter1.getBytes("iso-8859-1"),"utf-8");
		System.out.println(parameter1);
		List findAllDept = deptService.findAllDeptEmpt(parameter1);
		System.out.println(findAllDept.size());
		arg0.setAttribute("deptflag", parameter1);
		return new ModelAndView("admin/resource/market/performance/"+parameter, "showDeptl", findAllDept);
	}
	@RequestMapping("findAllDept.do")
	public String findAllDept(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("flagd");
		List findAllDept = deptService.findAllDept();
		HttpSession session = arg0.getSession();
		session.setAttribute("showDept", findAllDept);
		
		return "admin/resource/market/performance/"+parameter;
	}
	
	
//	lei
	@RequestMapping("findAllDept2.do")
	public String findAll(Model model){
		List findAllDept = deptService.findAllDept();
		model.addAttribute("findAllDept", findAllDept);
		return "admin/resource/sys/org/list";
		
	}
	

	@RequestMapping("findDept.do")
	public String findDept(String deptId,String flag,Model model,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse){
		 Dept findDept = deptService.findDept(deptId);
		
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		HttpSession session = request.getSession();
		
		session.setAttribute("findDept", findDept);
		if (flag!=null&&flag.equals("updateDept")) {
			try {
				request.getRequestDispatcher("findDeptFather.do").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		if (flag!=null&&flag.equals("addEmp")) {
			try {
				request.getRequestDispatcher("findDeptFather.do").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return "admin/resource/sys/org/view";
		
	}
	
	@RequestMapping("findDeptFather.do")
	public String findDeptFather(Model model,String flag){
		List findDeptFather = deptService.findDeptFather();
		model.addAttribute("findDeptFather", findDeptFather);
		//dept
		if (flag!=null&&flag.equals("updateDept")) {
				
			return "admin/resource/sys/org/edit";
		}
		return "admin/resource/sys/org/add";
		
	}
	
	@RequestMapping("findDeptShortName.do")
	public String findDeptShortName(Model model,String flag){
		List findDeptShortName = deptService.findDeptShortName();
		model.addAttribute("findDeptShortName", findDeptShortName);
		//emp的添加
		if (flag!=null&&flag.equals("addEmp")) {
			
			return "admin/resource/sys/employee/add";
		}
		//emp的修改
		if (flag!=null&&flag.equals("updateEmp")) {
			
			return "admin/resource/sys/employee/edit";
		}
		return null;
		
	}
	
	
	
	@RequestMapping("addDept.do")
	public String add(Dept findDept,Model model){
		int save = deptService.save(findDept);
		model.addAttribute("findDept", findDept);
		return "admin\\resource\\sys\\org\\view";
	}
	
	@RequestMapping("deleteDept.do")
	public String delete(String deptId,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse){
		
		int delete = deptService.delete(deptId);
		
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		try {
			request.getRequestDispatcher("findAllDept.do").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("updateDept.do")
	public String update(Dept dept,String flag,Model model,HttpServletRequest ServletRequest, HttpServletResponse ServletResponse){
		
		Dept findDept = deptService.findDept(dept.getDeptId());
		findDept.setDeptUpdateTime(time);
		
		HttpServletRequest request=(HttpServletRequest)ServletRequest;
		HttpServletResponse response=(HttpServletResponse)ServletResponse;
		
		if (flag!=null&&flag.equals("updateDept")) {
			System.out.println("ddddddd");
			findDept.setDeptId(dept.getDeptId());
			findDept.setDeptShortName(dept.getDeptShortName());
			findDept.setDeptAllName(dept.getDeptAllName());
			findDept.setDeptFather(dept.getDeptFather());
			findDept.setDeptIntro(dept.getDeptIntro());
			findDept.setDeptRemark(dept.getDeptRemark());
			
			deptService.update(findDept);
			model.addAttribute("findDept", findDept);
			return "admin\\resource\\sys\\org\\result";
				
			}
		
		return null;
	}
}

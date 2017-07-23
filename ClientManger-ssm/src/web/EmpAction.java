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

import service.EmpService;
import service.RoleService;
import entity.Emp;
import entity.Role;

@Controller
public class EmpAction {
	java.sql.Date time = new java.sql.Date(System.currentTimeMillis());
	@Resource(name = "empServiceImpl")
	private EmpService empService = null;

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	@RequestMapping("admin/findLogin.do")
	public String findLogin(Emp emp, HttpServletRequest arg0,
			HttpServletResponse arg1) {
		HttpSession session = arg0.getSession();
		Emp empuserinfo = empService.findLogin(emp);
		if (empuserinfo != null) {
			session.setAttribute("userinfo", empuserinfo);
			try {
				arg1.sendRedirect("../findRoleId.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "admin/Login";
	}

	// @RequestMapping("findAllEmp.do")
	// public ModelAndView findAllEmp(HttpServletRequest arg0,
	// HttpServletResponse arg1) throws Exception {
	// List findAllEmp = empService.findAllEmp();
	// return new ModelAndView("show", "showUser", findAllEmp);
	// }

	@RequestMapping("findByRoleEmp.do")
	public ModelAndView findByRoleEmp(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String emprole = arg0.getParameter("emprole");
		emprole = new String(emprole.getBytes("iso-8859-1"), "utf-8");
		List findAllEmp = empService.findByRoleEmp(emprole);
		return new ModelAndView("admin/resource/market/plan/add",
				"showemprole", findAllEmp);
	}

	// lei
	@RequestMapping("findAllEmp.do")
	public String findAll(Model model) {
		List findAllEmp = empService.findAllEmp();
		model.addAttribute("findAllEmp", findAllEmp);
		return "admin/resource/sys/employee/list";
	}

	@RequestMapping("findEmp.do")
	public String findEmp(String empId, String flag, Model model,
			HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {
		Emp findEmp = empService.findEmp(empId);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		HttpSession session = request.getSession();

		session.setAttribute("findEmp", findEmp);

		if (flag != null && flag.equals("updateEmp")) {
			try {
				request.getRequestDispatcher("findDeptShortName.do").forward(
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

		if (flag != null && flag.equals("shouquan")) {
			try {
				request.getRequestDispatcher("findAllRole.do").forward(request,
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
		return "admin/resource/sys/employee/view";
	}

	@RequestMapping("addEmp.do")
	public String add(Emp findEmp, Model model) {
		int save = empService.save(findEmp);
		model.addAttribute("findEmp", findEmp);
		return "admin\\resource\\sys\\employee\\view";
	}

	@RequestMapping("deleteEmp.do")
	public String delete(String empId, HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {

		int delete = empService.delete(empId);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		try {
			request.getRequestDispatcher("findAllEmp.do").forward(request,
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

	@RequestMapping("updateEmp.do")
	public String update(Emp emp, String flag, Model model,
			HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {

		Emp findEmp = empService.findEmp(emp.getEmpId());
		findEmp.setEmpUpdateTime(time);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;

		if (flag != null && flag.equals("updateEmp")) {
			findEmp.setEmpId(emp.getEmpId());
			findEmp.setEmpName(emp.getEmpName());
			findEmp.setEmpSex(emp.getEmpSex());
			findEmp.setEmpPhone(emp.getEmpPhone());
			findEmp.setEmpState(emp.getEmpState());
			findEmp.setEmpDept(emp.getEmpDept());
			findEmp.setEmpRole(emp.getEmpRole());
			findEmp.setEmpRemark(emp.getEmpRemark());
			empService.update(findEmp);
			model.addAttribute("findEmp", findEmp);
			return "admin\\resource\\sys\\employee\\result";

		}
		if (flag != null && flag.equals("pwd")) {
			findEmp.setEmpPassword(emp.getEmpPassword());
			int update = empService.update(findEmp);
			model.addAttribute("update", update);
			return "admin\\resource\\sys\\myinfo\\editps";
		}

		if (flag != null && flag.equals("empRole1")) {
			findEmp.setEmpRole(emp.getEmpRole());
			int update = empService.update(findEmp);
			model.addAttribute("findEmp", findEmp);
			return "admin\\resource\\sys\\employee\\result";
		}

		if (flag != null && flag.equals("loginName")) {
			findEmp.setEmpLoginName(emp.getEmpLoginName());
			int update = empService.update(findEmp);
			model.addAttribute("update", update);
			return "admin\\resource\\sys\\myinfo\\view";
		}

		// 禁用
		findEmp.setEmpState(emp.getEmpState());
		int update = empService.update(findEmp);
		try {
			request.getRequestDispatcher("findAllEmp.do").forward(request,
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

	@RequestMapping("findRoleId.do")
	public String findRoleId(HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		HttpSession session = request.getSession();
		Emp emp = (Emp) session.getAttribute("userinfo");
		String roleId = empService.findEmp2(emp);
		return "forward:tree.do?roleId=" + roleId;

	}
}

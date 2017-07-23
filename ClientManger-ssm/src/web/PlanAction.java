package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.PlanService;
import entity.Emp;
import entity.Plan;

@Controller
public class PlanAction {
	@Resource(name = "planServiceImpl")
	private PlanService planService = null;
	public static int PAGE = 5;

	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}

	@RequestMapping("deletePlan.do")
	public void deletePlan(Plan plan, HttpServletRequest arg0,
			HttpServletResponse arg1) {
		int insertPlan = planService.deletePlan(plan.getPlanId());
		try {
			arg0.getRequestDispatcher("findByPageStatePlan.do").forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("addPlan.do")
	public String addPlan(Plan plan, HttpServletRequest arg0) {
		Date date = new Date(System.currentTimeMillis());
		plan.setPlanUpdateTime(date);
		System.out.println(plan.getPlanState());
		int insertPlan = planService.insertPlan(plan);
		if (insertPlan == 1) {
			arg0.setAttribute("plana", plan);
		} else {
			arg0.setAttribute("plana", null);
		}
		return "admin/resource/market/plan/result";
	}

	@RequestMapping("updatePlan.do")
	public String updatePlan(Plan plan) {
		Date date = new Date(System.currentTimeMillis());
		plan.setPlanUpdateTime(date);
		int insertPlan = planService.updatePlan(plan);
		return "forward:findByPageStatePlan.do";
	}
	@RequestMapping("updatePlanState.do")
	public String updatePlanState(Plan plan) {
		int insertPlan = planService.updatePlanState(plan);
		return "forward:findByPageStatePlan.do";
	}
	@RequestMapping("findAllPlan.do")
	public ModelAndView findAllPlan(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		List findAllPlan = planService.findAllPlan();
		return new ModelAndView("admin/resource/market/plan/list", "showPlan",
				findAllPlan);
	}
	
	@RequestMapping("findByPageStatePlan.do")
	public ModelAndView findByPageStatePlan(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("currentPage");
		HttpSession session = arg0.getSession();
		Emp emp = (Emp)session.getAttribute("userinfo");
		//当前的页面数
		int currpage = 1;
		//末尾位置
		int last = 5;
		if (parameter != null) {
			currpage = Integer.parseInt(parameter);
		}
		if (currpage <= 0) {
			currpage = 1;
		}
		//总的记录数
		int findcount = planService.findcount(emp.getEmpName());
		//总页数    这里面的PAGE就是每页显示几条记录
		int sumpage = findcount % PAGE == 0 ? findcount / PAGE : findcount
				/ PAGE + 1;
		if (currpage > sumpage) {
			currpage = sumpage;
		}
		//起始位置
		int first = (currpage - 1) * PAGE + 1;
		last = first + PAGE-1;
		if (last > findcount) {
			last = findcount;
		}
		arg0.setAttribute("sumcount", findcount);
		arg0.setAttribute("sumpage", sumpage);
		arg0.setAttribute("pages", PAGE);
		arg0.setAttribute("currentPagew", currpage);
		List findAllPlan = planService.findByPageStatePlan(emp.getEmpName(),first, last);
		return new ModelAndView("admin/resource/market/plan/list", "showPlan",
				findAllPlan);
	}
	

	@RequestMapping("findByIdPlan.do")
	public ModelAndView findByIdPlan(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("planId");
		String flag = arg0.getParameter("flag");
		Plan findByIdPlan = planService.findByIdPlan(parameter);
		return new ModelAndView("admin/resource/market/plan/" + flag, "plana",
				findByIdPlan);
	}
}

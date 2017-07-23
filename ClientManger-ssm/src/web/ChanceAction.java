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

import entity.Chance;
import entity.Emp;
import entity.Plan;

import service.ChanceService;
import service.EmpService;

@Controller
public class ChanceAction {
	public static int PAGE = 5;
	
	@Resource(name = "empServiceImpl")
	private EmpService empService = null;

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	@Resource(name = "chanceServiceImpl")
	private ChanceService chanceService = null;

	public ChanceService getChanceService() {
		return chanceService;
	}

	public void setChanceService(ChanceService chanceService) {
		this.chanceService = chanceService;
	}
	@RequestMapping("updateChanceControl.do")
	public String updateChanceControl(Chance chance,HttpServletRequest arg0) {
		Date date = new Date(System.currentTimeMillis());
		chance.setChanceUpdateTime(date);
		HttpSession session = arg0.getSession();
		Emp emp = (Emp)session.getAttribute("userinfo");
		chance.setChanceController(emp.getEmpName());
		
		int insertPlan = chanceService.updateChanceControl(chance);
		return "forward:findAllChance.do";
	}
	@RequestMapping("updateChance.do")
	public String updateChance(Chance chance) {
		Date date = new Date(System.currentTimeMillis());
		chance.setChanceUpdateTime(date);
		int insertPlan = chanceService.updateChance(chance);
		return "forward:findAllChance.do";
	}
	
	@RequestMapping("addChance.do")
	public String addChance(Chance chance, HttpServletRequest arg0) {
		Date date = new Date(System.currentTimeMillis());
		chance.setChanceUpdateTime(date);
		chance.setChanceCreateTime(date);
		HttpSession session = arg0.getSession();
		Emp emp = (Emp)session.getAttribute("userinfo");
		chance.setChanceCreater(emp.getEmpName());
		int insertPlan = chanceService.insertChance(chance);
		if (insertPlan == 1) {
			arg0.setAttribute("Chance", chance);
		} else {
			arg0.setAttribute("Chance", null);
		}
		return "admin/resource/market/opp/result";
	}

	
	@RequestMapping("findByIdChance.do")
	public ModelAndView findByIdChance(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("ChanceId");
		String flag = arg0.getParameter("flagC");
		if(flag.equals("assign")){
		List findAllEmp = empService.findByRoleEmp("销售代表");
		System.out.println(findAllEmp.size());
		arg0.setAttribute("chanceemp", findAllEmp);
		}
		Chance chance= chanceService.findByIdChance(parameter);
		return new ModelAndView("admin/resource/market/opp/" + flag, "Chance",
				chance);
	}
	@RequestMapping("deleteChance.do")
	public void deleteChance(Chance chance, HttpServletRequest arg0,
			HttpServletResponse arg1) {
		int insertPlan = chanceService.deleteChance(chance.getChanceId());
		try {
			arg0.getRequestDispatcher("findAllChance.do").forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("findAllChance.do")
	public ModelAndView findAllChance(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("currentPage");
		int findcount = chanceService.findcountChance();
		int[] a = this.PageFind(parameter,findcount);
		arg0.setAttribute("sumcount", findcount);
		arg0.setAttribute("sumpage", a[0]);
		arg0.setAttribute("pages", PAGE);
		arg0.setAttribute("currentPagew", a[1]);
		List findAllPlan = chanceService.findAllChance(a[2], a[3]);
		return new ModelAndView("admin/resource/market/opp/list", "showChance",
				findAllPlan);	
	}
	  public static int[] PageFind(String parameter,int findcount){
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
			int a[]={sumpage,currpage,first,last};
			return a;
	    }

}

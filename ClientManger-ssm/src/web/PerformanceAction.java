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

import service.DeptService;
import service.PerformanceService;
import entity.Emp;
import entity.Performance;
import entity.Plan;

@Controller
public class PerformanceAction {
	public static int PAGE = 5;
	@Resource(name = "deptServiceImpl")
	private DeptService deptService = null;


	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
    
	@Resource(name = "performanceServiceImpl")
	private PerformanceService performanceService = null;

	public PerformanceService getPerformanceService() {
		return performanceService;
	}

	public void setPerformanceService(PerformanceService performanceService) {
		this.performanceService = performanceService;
	}
	@RequestMapping("deleteAllPerformance.do")
	public void deleteAllPerformance(Performance performance, HttpServletRequest arg0,
			HttpServletResponse arg1) {
		String[] ids = performance.getIds();
		if(ids!=null){
		for (String string : ids) {
			int insertPlan = performanceService.deletePerformance(string);
		}
		}
		try {
			arg0.getRequestDispatcher("findAllPerformance.do").forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("updatePerformance.do")
	public String updatePerformance(Performance performance) {
		Date date = new Date(System.currentTimeMillis());
		
		performance.setPerfUpdateTime(date);
		
		int insertPlan = performanceService.updatePerformance(performance);
		return "forward:findAllPerformance.do";
	}
	@RequestMapping("deletePerformance.do")
	public void deletePerformance(Performance performance, HttpServletRequest arg0,
			HttpServletResponse arg1) {
		int insertPlan = performanceService.deletePerformance(performance.getPerfId());
		try {
			arg0.getRequestDispatcher("findAllPerformance.do").forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("findByIdPerformance.do")
	public ModelAndView findByIdPerformance(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("perfId");
		String flag = arg0.getParameter("flag");
		HttpSession session = arg0.getSession();
		if(flag.equals("edit")){
		List findAllDept = deptService.findAllDept();
		session.setAttribute("showDept", findAllDept);
		}
		Performance performance = performanceService.findByIdPerformance(parameter);
		session.setAttribute("seper", performance);
		return new ModelAndView("admin/resource/market/performance/" + flag, "performancell",
				performance);
	}

	@RequestMapping("addPerformance.do")
	public String addPerformance(Performance performance, HttpServletRequest arg0) {
		Date date = new Date(System.currentTimeMillis());
		HttpSession session = arg0.getSession();
		Emp emp = (Emp)session.getAttribute("userinfo");
		
		performance.setPerfUpdateTime(date);
		performance.setPerfDel(new BigDecimal(0));
		performance.setPerfController(emp.getEmpName());
		int insertPlan = performanceService.insertPerformance(performance);
		if (insertPlan == 1) {
			System.out.println("aaaaaaa");
			arg0.setAttribute("performance", performance);
		} else {
			arg0.setAttribute("performance", null);
		}
		return "admin/resource/market/performance/result";
	}
	
	
	@RequestMapping("findAllPerformance.do")
	public ModelAndView findAllPerformance(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("currentPage");
		int findcount = performanceService.findcountPerfor();
		int[] a = this.PageFind(parameter,findcount);
		arg0.setAttribute("sumcount", findcount);
		arg0.setAttribute("sumpage", a[0]);
		arg0.setAttribute("pages", PAGE);
		arg0.setAttribute("currentPagew", a[1]);
		List findAllPlan = performanceService.findAllPerformance(a[2], a[3]);
		return new ModelAndView("admin/resource/market/performance/list", "showPerfor",
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

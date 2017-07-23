package web;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
 
import entity.ClientPlan;
import entity.Emp;

import service.ClientPlanService;

@Controller
public class ClientPlanAction {
	@Resource(name = "ClientPlanServiceImpl")
	ClientPlanService clientPlanService=null;

	public ClientPlanService getClientPlanService() {
		return clientPlanService;
	}

	public void setClientPlanService(ClientPlanService clientPlanService) {
		this.clientPlanService = clientPlanService;
	}
	final int PAGE=5;
	
 

	@RequestMapping("addClientPlan.do")
	public String addClientPlan(ClientPlan clientplan)
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		int a=clientPlanService.addClientPlan(clientplan);
		
		HttpSession session=request.getSession();
		Emp emp=(Emp) session.getAttribute("userinfo");
		Date date = new Date(System.currentTimeMillis());
		clientplan.setPlanController(emp.getEmpName());
		clientplan.setPlanUpdateTime(date);
		request.setAttribute("plan", clientplan);
		return "admin/resource/customer/develop/result";
		
	}
	@RequestMapping("allClientPlan.do")
	public ModelAndView findAllPlan(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("sssss");
		String parameter = arg0.getParameter("currentPage");
		int currentPage=1;
		int last=5;
		if(parameter!=null){
			currentPage=Integer.parseInt(parameter);
		}
		if(currentPage<=0){
			currentPage=1;
		}
		int findCount=clientPlanService.findCount();
		System.out.println(findCount);
	
		int sumPage=findCount%PAGE==0?findCount/PAGE:findCount/PAGE+1;
		if(currentPage>sumPage){
			currentPage=sumPage;
		}
		int first=(currentPage-1)*PAGE+1;
		last=first+PAGE-1;
		if(last>findCount){
			last=findCount;
		}
		arg0.setAttribute("sumCount", findCount);
		arg0.setAttribute("sumPage", sumPage);
		arg0.setAttribute("pages", PAGE);
		arg0.setAttribute("currentPage", currentPage);
		List clientPlan = clientPlanService.allClientPlan(first, last);
		System.out.println(clientPlan.size());
		return new ModelAndView("admin/resource/customer/develop/list", "all", clientPlan);
	} 
	@RequestMapping("selectClientPlan.do")
	public String addClientPlan(String planId) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		ClientPlan plan=clientPlanService.findById(planId);
		request.setAttribute("plan", plan);
		String type=request.getParameter("type");
		if(type.equals("select")){
			return "admin/resource/customer/develop/view";
		}
		else{
			return "admin/resource/customer/develop/edit";
		}
		
	} 
	@RequestMapping("updateClientPlan.do")
	public String updateClientPlan(ClientPlan clientplan) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Date date = new Date(System.currentTimeMillis());
		HttpSession session=request.getSession();
		Emp emp=(Emp) session.getAttribute("userinfo");
		
		ClientPlan plan=clientPlanService.findById(clientplan.getPlanId());
		plan.setPlanUpdateTime(date);
		plan.setPlanController(emp.getEmpName());
		request.setAttribute("plan",plan);
		
		int a =clientPlanService.updateClientPlan(clientplan);
		if(a==1){
			return "admin/resource/customer/develop/result";
		}
		else{
			return "admin/resource/customer/develop/edit";
		}
		
	} 
	
	@RequestMapping("deleteClientPlan.do")
	public String deleteClietnPlan(String planId){
		int delete =clientPlanService.deleteClientPlan(planId);
	
		return "admin/resource/customer/develop/list";
		

		
	}
	
}

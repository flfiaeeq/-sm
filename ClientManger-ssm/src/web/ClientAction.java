package web;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.Client;
import entity.Emp;
import entity.Order;

import service.ClientsService;
import service.EmpService;

@Controller
public class ClientAction {
	@Resource(name = "ClientServiceImpl")
	ClientsService clientService=null;

	public ClientsService getClientService() {
		return clientService;
	}

	public void setClientService(ClientsService clientService) {
		this.clientService = clientService;
	}
	@Resource(name ="empServiceImpl")
	EmpService empservice=null;
	
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}
	
	public EmpService getEmpservice() {
		return empservice;
	}
	final int PAGE=5;
	 
	@RequestMapping("findoneClinetAssign.do")
	public  String findOneClientAssign(String clientId) {
		Client client=clientService.findClientById(clientId);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("c", client);
		List l = empservice.findEmpRole();
		
		request.setAttribute("role", l);
		return "admin/resource/customer/resource/assign";
		//return new ModelAndView("addClient", "addClient",null);
	}
	@RequestMapping("findoneClinet.do")
	public  String findOneClient(String clientId) {
		Client client=clientService.findClientById(clientId);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("c", client);
		String t=request.getParameter("type");
		List type=clientService.findClientType();
		System.out.println("ssssssssss");
		System.out.println(type.size()+"---------");
		request.setAttribute("ty", type);
		if(t.equals("select")){
			return "admin/resource/customer/resource/view";
		}
		else{
			return "admin/resource/customer/resource/edit";
		}
		
		//return new ModelAndView("addClient", "addClient",null);
	}
	@RequestMapping("deleteClinetSatisfaction.do")
	public  String deleteClientSatisfaction(String clientId) {
		 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		int a=clientService.deleteClientSatisfaction(clientId);
		return "forward:findAllClient.do?type=aaaaa";
		 
	}
	@RequestMapping("findClientSatisfaction.do")
	public  String findClientSatisfaction(String clientId) {
		Client client=clientService.findClientSatisfaction(clientId);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String method=request.getParameter("method");
		if(method.equals("update")){
			request.setAttribute("satisfaction", client);
			return "admin/resource/customer/satisfaction/edit";
		}
		else if(method.equals("select")){
			request.setAttribute("satisfaction", client);
			return "admin/resource/customer/satisfaction/view";
		}
		else{
			request.setAttribute("satisfaction", client);
			
			return "admin/resource/customer/satisfaction/add";
		}
		
		
	}
	@RequestMapping("upateClientAssgin.do")
	public  String updateClientAssgin(Client client) {
		Date date = new Date(System.currentTimeMillis());
		client.setClientUpdateTime(date);
		int a=clientService.updateClientAssgin(client);
		 
		return "forward:findAllClient.do?type=aaaaa";
		//return new ModelAndView("addClient", "addClient",null);
	}
	@RequestMapping("upateClient.do")
	public  String updateClient(Client client) {
		 HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		 HttpSession session=request.getSession();
		 Date date = new Date(System.currentTimeMillis());
		 client.setClientUpdateTime(date);
		 Emp emp=(Emp) session.getAttribute("userinfo");
		 client.setClientController(emp.getEmpName());
		 int a=clientService.updateClient(client);
		 
		 return "forward:findAllClient.do?type=aaaaa";
		//return new ModelAndView("addClient", "addClient",null);
	}
	
	
	@RequestMapping("findAllClient.do")
	public ModelAndView findAllEmp(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("currentPage");
		int currentPage=1;
		int last=5;
		if(parameter!=null){
			currentPage=Integer.parseInt(parameter);
		}
		if(currentPage<=0){
			currentPage=1;
		}
		int findCount=clientService.findCount();
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
		List findAllClient = clientService.findAll(first, last);
		System.out.println(findAllClient.size());
		String type=arg0.getParameter("type");
		HttpSession session=arg0.getSession();
		Emp emp=(Emp) session.getAttribute("userinfo");
		arg0.setAttribute("emp", emp);
		if(type.equals("satisfaction")){
			return new ModelAndView("admin/resource/customer/satisfaction/list", "showClient", findAllClient);
		}
		else if(type.equals("value")){
			return new ModelAndView("admin/resource/customer/value/list", "showClient", findAllClient);
		}
		else{
			return new ModelAndView("admin/resource/customer/resource/list", "showClient", findAllClient);
		}
		
	}
	@RequestMapping("addClient.do")
	public  String addClient(Client client) {
		 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		HttpSession session=request.getSession();
		 Emp emp=(Emp) session.getAttribute("userinfo");
		 client.setClientController(emp.getEmpName());
		 client.setClientCreater(emp.getEmpName());
		
		Date date = new Date(System.currentTimeMillis());
		
		client.setClientUpdateTime(date);
		client.setClientCreateTime(date);
		int a=clientService.addClient(client);
		request.setAttribute("c", client);
		System.out.println(client.getClientId());
		return "admin/resource/customer/resource/result";
		//return new ModelAndView("addClient", "addClient",null);
	}
	@RequestMapping("addClientSatisfaction.do")
	public  String addClientSatisfaction(Client client) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String method=request.getParameter("method");
		int a=clientService.addClientSatisfaction(client);
		Client client1=clientService.findClientById(client.getClientId());
		System.out.println("youuuu"+client1.getClientAddress());
		request.setAttribute("c", client1);
		System.out.println(a);
		return "admin/resource/customer/satisfaction/result";
		//return new ModelAndView("addClient", "addClient",null);
	}
	@RequestMapping("findClientOrder.do")
	public  String findClientOrder(String clientId) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Client client=clientService.findClientById(clientId);
		System.out.println(client.getClientName());
		List list=clientService.findAllOrder(client.getClientName());
		System.out.println("order"+list.size());
		//map.put("client", client);
		//map.put("list", list);
		request.setAttribute("c", client);
		request.setAttribute("order", list);
		return "admin/resource/customer/value/view";
		//return new ModelAndView("addClient", "addClient",null);
	}
	
}

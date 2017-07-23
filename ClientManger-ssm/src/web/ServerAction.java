package web;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Server;

import service.EmpService;
import service.ServerService;

@Controller
public class ServerAction {
	@Resource(name = "serverServiceImpl")
	private ServerService serverService = null;

	public ServerService getServerService() {
		return serverService;
	}

	public void setServerService(ServerService serverService) {
		this.serverService = serverService;
	}

	final int page = 5;

	/*
	 * 一、服务创建
	 */
	// 分页查找
	@RequestMapping("findByPageServer.do")
	public ModelAndView findByPageCreate(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取页面传过来的page
		String current = request.getParameter("page");
		// 当前的页面数
		int currentPage = 1;
		int last = 5;
		if (current != null) {
			currentPage = Integer.parseInt(current);
		}
		if (currentPage <= 0) {
			currentPage = 1;
		}
		// 总记录数
		int findCount = serverService.findCount();
		// 总页数
		int sumPage = findCount % page == 0 ? findCount / page : findCount
				/ page + 1;
		if (currentPage > sumPage) {
			currentPage = sumPage;
		}
		// 起始位置
		int first = (currentPage - 1) * page + 1;
		last = first + page - 1;
		if (last > findCount) {
			last = findCount;
		}
		request.setAttribute("sumCount", findCount);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("page", page);
		request.setAttribute("currentPage", currentPage);
		List list = serverService.findByPageServer(first, last);
		System.out.println(list.size());
		return new ModelAndView("admin/resource/services/create/list", "list",
				list);
	}

	// 添加
	@RequestMapping("addServer.do")
	public String addServer(Server s, HttpServletRequest request)
			throws Exception {
		String creater = request.getParameter("serverCreater");
		Date date = new java.sql.Date(System.currentTimeMillis());
		s.setServerCreateTime(date);
		s.setServerCreater(creater);
		s.setServerState(0);
		int i = serverService.saveServer(s);
		request.setAttribute("server", s);
		return "admin/resource/services/create/result";
	}

	// 删除
	@RequestMapping("deleteServer.do")
	public String deleteUser(Server s, HttpServletRequest request)
			throws Exception {
		String server1 = request.getParameter("serverName");
		String serverName = new String(server1.getBytes("iso8859-1"), "utf-8");
		System.out.println(serverName + "44444444");
		serverService.deleteServer(serverName);
		System.out.println("delete:" + s.getServerName());
		return "forward:findByPageServer.do";
	}

	// 批量删除
	@RequestMapping("deleteAllServer.do")
	public String deleteServer2(String[] checkName) throws Exception {
		System.out.println(checkName.length + "ssssssssssssss");
		serverService.deleteAllServer(checkName);
		return "forward:findByPageServer.do";
	}

	// 修改
	@RequestMapping("updateServer.do")
	public String updateServer(Server s, HttpServletRequest request) {
		String flag = request.getParameter("flag");
		s = serverService.findByNameServer(s.getServerName());
		s.setServerType(request.getParameter("serverType"));
		s.setServerClientName(request.getParameter("serverClientName"));
		s.setServerClientTel(request.getParameter("serverClientTel"));
		s.setServerContext(request.getParameter("serverContext"));
		s.setServerRemark(request.getParameter("serverRemark"));
		s.setServerController(request.getParameter("serverController"));
		System.out.println("update:" + s.getServerName());
		Date date = new java.sql.Date(System.currentTimeMillis());
		s.setServerUpdateTime(date);
		serverService.updateServer(s);
		return "forward:findByPageServer.do";
	}

	// 修改：提交改变状态
	@RequestMapping("serverSubmit.do")
	public String serverSubmit(Server s, HttpServletRequest request)
			throws Exception {

		String name1 = request.getParameter("serverName");
		String control1 = request.getParameter("serverController");
		String serverName = new String(name1.getBytes("iso8859-1"), "utf-8");
		String control = new String(control1.getBytes("iso8859-1"), "utf-8");
		System.out.println(serverName + "11111111111");
		System.out.println(control + "2222222222");
		s.setServerName(serverName);
		s.setServerController(control);
		String flag = request.getParameter("flag");
		if (flag.equals("update")) {
			// s = serverService.findByNameServer(s.getServerName());
			s.setServerState(1);
		}
		System.out.println("serverSubmit:" + s.getServerName());
		Date date = new java.sql.Date(System.currentTimeMillis());
		s.setServerUpdateTime(date);
		serverService.serverSubmit(s);
		return "forward:findByPageServer.do";
	}

	// 通过名字查找
	@RequestMapping("fidnByNameServer.do")
	public ModelAndView findByName(Server s, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String flag = request.getParameter("flag");
		// String name=request.getParameter("serverName");
		if (s.getServerName() != null) {
			String serverName = new String((s.getServerName())
					.getBytes("iso8859-1"), "utf-8");
			s = serverService.findByNameServer(serverName);
		}

		return new ModelAndView("admin/resource/services/create/" + flag,
				"server", s);

	}

	/*
	 * 
	 * 二、服务分配
	 */
	// 分页查找
	@RequestMapping("findByPageServer1.do")
	public ModelAndView findByPageAssign(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取页面传过来的page
		String current = request.getParameter("page");
		// 当前的页面数
		int currentPage = 1;
		int last = 5;
		if (current != null) {
			currentPage = Integer.parseInt(current);
		}
		if (currentPage <= 0) {
			currentPage = 1;
		}
		// 总记录数
		int findCount = serverService.findCount1();
		// 总页数
		int sumPage = findCount % page == 0 ? findCount / page : findCount
				/ page + 1;
		if (currentPage > sumPage) {
			currentPage = sumPage;
		}
		// 起始位置
		int first = (currentPage - 1) * page + 1;
		last = first + page - 1;
		if (last > findCount) {
			last = findCount;
		}
		request.setAttribute("sumCount", findCount);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("page", page);
		request.setAttribute("currentPage", currentPage);
		List list = serverService.findByPageServer1(first, last);
		System.out.println("findByPageAssign:" + list.size());
		return new ModelAndView("admin/resource/services/assign/list", "list",
				list);
	}

	// 根据名字查找
	@RequestMapping("fidnByNameServer1.do")
	public ModelAndView findByName1(Server s, HttpServletRequest request)
			throws Exception {
		String flag = request.getParameter("flag");
		String name1 = request.getParameter("serverName");

		if (name1 != null) {
			if (flag.equals("result")) {
				s = serverService.findByNameServer(name1);
			} else {
				String serverName = new String(name1.getBytes("iso8859-1"),
						"utf-8");
				s = serverService.findByNameServer(serverName);
			}
		}

		return new ModelAndView("admin/resource/services/assign/" + flag,
				"server", s);

	}

	// 修改：进行分配
	@RequestMapping("updateServer1.do")
	public String updateServer1(Server s, HttpServletRequest request) {
		System.out.println(s.getServerHandler() + "111111111111111");
		System.out.println(s.getServerController() + "222222222222");
		System.out.println(s.getServerState() + ":3333333333333");
		System.out.println(s.getServerName() + "444444444444");

		s.setServerHandler(s.getServerHandler());
		s.setServerController(s.getServerController());
		Date date = new java.sql.Date(System.currentTimeMillis());
		s.setServerUpdateTime(date);
		if (s.getServerState() == 1) {
			s.setServerState(2);
		}
		serverService.serverAssign(s);// 更改
		return "forward:fidnByNameServer1.do?flag=result&&serverName="
				+ s.getServerName();
	}

	/*
	 * 三、服务处理
	 */
	@RequestMapping("findByPageServer2.do")
	public ModelAndView findByPageHandle(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取页面传过来的page
		String current = request.getParameter("page");
		// 当前的页面数
		int currentPage = 1;
		int last = 5;
		if (current != null) {
			currentPage = Integer.parseInt(current);
		}
		if (currentPage <= 0) {
			currentPage = 1;
		}
		// 总记录数
		int findCount = serverService.findCount2();
		// 总页数
		int sumPage = findCount % page == 0 ? findCount / page : findCount
				/ page + 1;
		if (currentPage > sumPage) {
			currentPage = sumPage;
		}
		// 起始位置
		int first = (currentPage - 1) * page + 1;
		last = first + page - 1;
		if (last > findCount) {
			last = findCount;
		}
		request.setAttribute("sumCount", findCount);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("page", page);
		request.setAttribute("currentPage", currentPage);
		List list = serverService.findByPageServer2(first, last);
		System.out.println("findByPagehandle:" + list.size());
		return new ModelAndView("admin/resource/services/handle/list", "list",
				list);
	}

	@RequestMapping("fidnByNameServer2.do")
	public ModelAndView findByName2(Server s, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String flag = request.getParameter("flag");
		String name1 = request.getParameter("serverName");
		if (name1 != null) {
			if (flag.equals("result")) {
				s = serverService.findByNameServer(name1);
			} else {
				String serverName = new String(name1.getBytes("iso8859-1"),
						"utf-8");
				s = serverService.findByNameServer(serverName);
			}
		}
		return new ModelAndView("admin/resource/services/handle/" + flag,
				"server", s);

	}

	// 修改:进行处理
	@RequestMapping("updateServer2.do")
	public String updateServer2(Server s, HttpServletRequest request) {
		s.setServerHandleContext(s.getServerHandleContext());
		s.setServerState(s.getServerState());
		Date date = new java.sql.Date(System.currentTimeMillis());
		s.setServerUpdateTime(date);
		serverService.serverHandle(s);// 修改
		return "forward:fidnByNameServer2.do?flag=result&&serverName="
			+ s.getServerName();
	}

	/*
	 * 四、服务反馈
	 */
	@RequestMapping("findByPageServer3.do")
	public ModelAndView findByPageFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取页面传过来的page
		String current = request.getParameter("page");
		// 当前的页面数
		int currentPage = 1;
		int last = 5;
		if (current != null) {
			currentPage = Integer.parseInt(current);
		}
		if (currentPage <= 0) {
			currentPage = 1;
		}
		// 总记录数
		int findCount = serverService.findCount3();
		// 总页数
		int sumPage = findCount % page == 0 ? findCount / page : findCount
				/ page + 1;
		if (currentPage > sumPage) {
			currentPage = sumPage;
		}
		// 起始位置
		int first = (currentPage - 1) * page + 1;
		last = first + page - 1;
		if (last > findCount) {
			last = findCount;
		}
		request.setAttribute("sumCount", findCount);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("page", page);
		request.setAttribute("currentPage", currentPage);
		List list = serverService.findByPageServer3(first, last);
		System.out.println("findByPageAssign:" + list.size());
		return new ModelAndView("admin/resource/services/feedback/list",
				"list", list);
	}

	@RequestMapping("fidnByNameServer3.do")
	public ModelAndView findByName3(Server s, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String flag = request.getParameter("flag");
		String name1 = request.getParameter("serverName");
		if (name1 != null) {
			if (flag.equals("result")) {
				s = serverService.findByNameServer(name1);
			} else {
				String serverName = new String(name1.getBytes("iso8859-1"),
						"utf-8");
				s = serverService.findByNameServer(serverName);
			}
		}
		return new ModelAndView("admin/resource/services/feedback/" + flag,
				"server", s);

	}

	// 修改:进行反馈
	@RequestMapping("updateServer3.do")
	public String updateServer3(Server s, HttpServletRequest request) {
		Date date = new java.sql.Date(System.currentTimeMillis());
		s.setServerUpdateTime(date);
		serverService.serverFeedBack(s);
		return "forward:fidnByNameServer3.do?flag=result&&serverName="
			+ s.getServerName();
	}

	/*
	 * 五、服务归档
	 */
	@RequestMapping("findByPageServer4.do")
	public ModelAndView findByPageFile(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取页面传过来的page
		String current = request.getParameter("page");
		// 当前的页面数
		int currentPage = 1;
		int last = 5;
		if (current != null) {
			currentPage = Integer.parseInt(current);
		}
		if (currentPage <= 0) {
			currentPage = 1;
		}
		// 总记录数
		int findCount = serverService.findCount4();
		// 总页数
		int sumPage = findCount % page == 0 ? findCount / page : findCount
				/ page + 1;
		if (currentPage > sumPage) {
			currentPage = sumPage;
		}
		// 起始位置
		int first = (currentPage - 1) * page + 1;
		last = first + page - 1;
		if (last > findCount) {
			last = findCount;
		}
		request.setAttribute("sumCount", findCount);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("page", page);
		request.setAttribute("currentPage", currentPage);
		List list = serverService.findByPageServer4(first, last);
		System.out.println("findByPageAssign:" + list.size());
		return new ModelAndView("admin/resource/services/file/list", "list",
				list);
	}

	@RequestMapping("fidnByNameServer4.do")
	public ModelAndView findByName4(Server s, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String flag = request.getParameter("flag");
		String serverName = new String((s.getServerName())
				.getBytes("iso8859-1"), "utf-8");
		s = serverService.findByNameServer(serverName);
		System.out.println("fidnByNameServer4:" + s.getServerName());
		return new ModelAndView("admin/resource/services/file/" + flag,
				"server", s);

	}

	// 修改:进行归档
	@RequestMapping("updateServer4.do")
	public String updateServer4(Server s) throws Exception {
		System.out.println("updateServer4:" + s.getServerName());
		String serverName = new String((s.getServerName())
				.getBytes("iso8859-1"), "utf-8");
		s = serverService.findByNameServer(serverName);
		// Date date = new java.sql.Date(System.currentTimeMillis());
		// s.setServerUpdateTime(date);
		if (s.getServerState() == 4) {
			s.setServerState(5);
		}
		serverService.serverFile(s);
		return "forward:findByPageServer4.do";
	}

}

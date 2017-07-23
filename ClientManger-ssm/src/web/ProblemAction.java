package web;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Problem;
import entity.Server;

import service.EmpService;
import service.ProblemService;

@Controller
public class ProblemAction {
	@Resource(name = "problemServiceImpl")
	private ProblemService problemService = null;

	public ProblemService getProblemService() {
		return problemService;
	}
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	final int page = 5 ;
	@RequestMapping("findAllProblem.do")
	public ModelAndView findAllEmp(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		List list = problemService.findAllProblem();
		System.out.println(list.size());
		return new ModelAndView("show", "list", list);
	}
	//分页查找
	@RequestMapping("findByPageProblem.do")
	public ModelAndView findByPageProblem(HttpServletRequest request,HttpServletResponse response){
		String current = request.getParameter("page");
		int currentPage = 1;
		int last = 5;
		if(current!=null){
			currentPage=Integer.parseInt(current);
		}
		if(currentPage<=0){
			currentPage=1;
		}
		int findCount = problemService.findCount();
		int sumPage = findCount%page==0?findCount/page:findCount/page+1;
		if(currentPage>sumPage){
			currentPage=sumPage;
		}
		int first = (currentPage-1)*page+1;
		last = first+page-1;
		if(last>findCount){
			last=findCount;
		}
		request.setAttribute("sumCount",findCount);
		request.setAttribute("sumPage",sumPage);
		request.setAttribute("page",page);
		request.setAttribute("currentPage",currentPage);
		List list = problemService.findByPageProblem(first, last);
		System.out.println(list.size());
		return new ModelAndView("admin/resource/services/question/list", "list",list);
	}
	//添加
	@RequestMapping("addProblem.do")
	public String addServer(Problem p){
		System.out.println(p.getProblemCreater()+"11111111111");
		Date date = new java.sql.Date(System.currentTimeMillis());
		p.setProblemCreateTime(date);
		int i = problemService.saveProblem(p);
		System.out.println("add:"+i);
		return "forward:fidnByTitleProblem.do?flag=result";
	}
	//删除
	@RequestMapping("deleteProblem.do")
	public String deleteProblem(Problem p) throws Exception{
		String problemTitle=new String((p.getProblemTitle()).getBytes("iso8859-1"),"utf-8");
		problemService.deleteProblem(problemTitle);
		System.out.println("delete:"+p.getProblemTitle());
		return "forward:findByPageProblem.do";
	}
	//修改
	@RequestMapping("updateProblem.do")
	public String updateProblem(Problem p,HttpServletRequest request){
		String flag = request.getParameter("flag");
//		p.setProblemType(request.getParameter("problemType"));
//		p.setProblemReply(request.getParameter("problemReply"));
//		p.setProblemRemark(request.getParameter("problemRemark"));
//		p.setProblemController(request.getParameter("problemController"));
		//p = problemService.findByTitleProblem(p.getProblemTitle());
		System.out.println("updateProblem:"+p.getProblemTitle());
		Date date = new java.sql.Date(System.currentTimeMillis());
		p.setProblemUpdateTime(date);
		System.out.println(p.getProblemController()+"sssss");
		problemService.updateProblem(p);
		return "forward:findByPageProblem.do";
	}
	//通过标题查找
	@RequestMapping("fidnByTitleProblem.do")
	public ModelAndView findByTitle(Problem p,HttpServletRequest request,HttpServletResponse response) throws Exception {		
		String flag=request.getParameter("flag");		
		String problemTitle=new String((p.getProblemTitle()).getBytes("iso8859-1"),"utf-8");
		p = problemService.findByTitleProblem(problemTitle);
		System.out.println(p.getProblemTitle()+"ccccc");
		System.out.println("findByTitleProblem:"+p.getProblemTitle());
		System.out.println(p.getProblemRemark()+"ddddddd");
		System.out.println(p.getProblemReply()+"qqqqqqq");
		return new ModelAndView("admin/resource/services/question/"+flag,"pro",p);	
		
	}

}

package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.NoticeService;
import entity.Menu;
import entity.Notice;

@Controller
public class NoticeAction {
	java.sql.Date time = new java.sql.Date(System.currentTimeMillis());
	private NoticeService noticeService;

	@Resource(name = "noticeServiceImpl")
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@RequestMapping("findAllNotice.do")
	public String findAll(Model model) {

		List findAllNotice = noticeService.findAllNotice();

		model.addAttribute("findAllNotice", findAllNotice);

		return "admin\\resource\\sys\\announcement\\list";
	}

	@RequestMapping("findAllNoticeType.do")
	public String findAllNoticeType(String flag, Model model) {

		List findAllNoticeType = noticeService.findAllNoticeType();
		model.addAttribute("findAllNoticeType", findAllNoticeType);

		if (flag != null && flag.equals("update")) {

			return "admin\\resource\\sys\\announcement\\edit";
		}
		return "admin\\resource\\sys\\announcement\\add";
	}

	@RequestMapping("findNotice.do")
	public String findNotice(String noticeId, String flag, Model model,
			HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {
		System.out.println(noticeId + "========" + flag);
		Notice findNotice = noticeService.findById(noticeId);
		// model.addAttribute("findNotice", findNotice);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		HttpSession session = request.getSession();

		session.setAttribute("findNotice", findNotice);
		if (flag.equals("xingxi")) {
			System.out.println("xingxi");
			return "admin\\resource\\sys\\announcement\\view";
		}
		if (flag.equals("update")) {
			try {
				request.getRequestDispatcher("findAllNoticeType.do").forward(
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
		if (flag.equals("addxiangxi")) {
			System.out.println("addxiangxi");
			return "admin\\resource\\sys\\announcement\\result";
		}
		return null;
	}

	@RequestMapping("addNotice.do")
	public String add(Notice notice, String flag,
			HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {

		notice.setNoticeAddTime(time);
		int save = noticeService.save(notice);
		System.out.println(save);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		try {

			request.getRequestDispatcher("findNotice.do").forward(request,
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

	@RequestMapping("deleteNotice.do")
	public String delete(String noticeId, HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {
		System.out.println(noticeId);
		int delete = noticeService.delete(noticeId);
		System.out.println(delete);
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		try {
			request.getRequestDispatcher("findAllNotice.do").forward(request,
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

	// ����/����/���·���/�޸�
	@RequestMapping("updateNotice.do")
	public String update(Notice notice, String flag, Model model,
			HttpServletRequest ServletRequest,
			HttpServletResponse ServletResponse) {
		System.out.println(notice.getNoticeId() + "----------"
				+ notice.getNoticeState());

		Notice findNotice = noticeService.findById(notice.getNoticeId());
		findNotice.setNoticeIssueTime(time);

		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		if (flag != null && flag.equals("updateNotice")) {

			findNotice.setNoticeTitle(notice.getNoticeTitle());
			findNotice.setNoticeContext(notice.getNoticeContext());
			findNotice.setNoticeIssuser(notice.getNoticeIssuser());
			findNotice.setNoticeType(notice.getNoticeType());
			findNotice.setNoticeState(notice.getNoticeState());
			noticeService.update(findNotice);
			model.addAttribute("findNotice", findNotice);
			return "admin\\resource\\sys\\announcement\\result";

		}

		// �����޸�״̬��
		findNotice.setNoticeState(notice.getNoticeState());
		noticeService.update(findNotice);

		try {

			request.getRequestDispatcher("findAllNotice.do").forward(request,
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

}

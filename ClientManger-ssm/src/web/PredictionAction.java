package web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.PredictionService;
import entity.Emp;
import entity.Plan;
import entity.Prediction;

@Controller
public class PredictionAction {
	public static int PAGE = 5;
	@Resource(name = "predictionServiceImpl")
	private PredictionService predictionService = null;

	public PredictionService getPredictionService() {
		return predictionService;
	}

	public void setPredictionService(PredictionService predictionService) {
		this.predictionService = predictionService;
	}

	@RequestMapping("addPrediction.do")
	public String addPrediction(Prediction prediction,
			@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest arg0) throws IOException {
		HttpSession session = arg0.getSession();
		Emp emp = (Emp) session.getAttribute("userinfo");
		Date date = new Date(System.currentTimeMillis());
		
		String path = session.getServletContext().getRealPath("uplod");
		String predictionFileName = new java.util.Date().getTime()
				+ file.getOriginalFilename();
		String pathString = path + "\\" + predictionFileName;
		

		prediction.setPredictionDel(new Byte("0"));
		prediction.setPredictionCreater(emp.getEmpName());
		prediction.setPredictionCreateTime(date);
		prediction.setPredictionFileName(predictionFileName);
		prediction.setPredictionFileUrl(path);
		
		try {
            //获取输出流
            OutputStream os=new FileOutputStream(pathString);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
           os.flush();
           os.close();
           is.close();
         
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		int insertPlan = predictionService.insertPrediction(prediction);
		if (insertPlan == 1) {
			arg0.setAttribute("prediction", prediction);
		} else {
			arg0.setAttribute("prediction", null);
		}
		return "admin/resource/market/forecast/result";
	}
    
	@RequestMapping("findByTitlePrediction.do")
	public ModelAndView findByTitlePrediction(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("predictionTitle");
		parameter =new String(parameter.getBytes("iso-8859-1"),"utf-8");
		String flag = arg0.getParameter("flag");
		Prediction prediction= predictionService.findByTitlePredic(parameter);
		System.out.println(prediction.getPredictionCreater());
		return new ModelAndView("admin/resource/market/forecast/" + flag, "prediction",
				prediction);
	}
	
	@RequestMapping("findAllPrediction.do")
	public ModelAndView findAllPrediction(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String parameter = arg0.getParameter("currentPage");
		// 当前的页面数
		int currpage = 1;
		// 末尾位置
		int last = 5;
		if (parameter != null) {
			currpage = Integer.parseInt(parameter);
		}
		if (currpage <= 0) {
			currpage = 1;
		}
		// 总的记录数
		int findcount = predictionService.findcountPredic();
		// 总页数 这里面的PAGE就是每页显示几条记录
		int sumpage = findcount % PAGE == 0 ? findcount / PAGE : findcount
				/ PAGE + 1;
		if (currpage > sumpage) {
			currpage = sumpage;
		}
		// 起始位置
		int first = (currpage - 1) * PAGE + 1;
		last = first + PAGE - 1;
		if (last > findcount) {
			last = findcount;
		}
		arg0.setAttribute("sumcount", findcount);
		arg0.setAttribute("sumpage", sumpage);
		arg0.setAttribute("pages", PAGE);
		arg0.setAttribute("currentPagew", currpage);
		List findAllPlan = predictionService.findAllPrediction(first, last);
		return new ModelAndView("admin/resource/market/forecast/list",
				"showPredic", findAllPlan);
	}

}

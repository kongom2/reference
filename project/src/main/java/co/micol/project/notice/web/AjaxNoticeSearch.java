package co.micol.project.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.micol.project.notice.service.NoticeService;
import co.micol.project.notice.service.NoticeVO;
import co.micol.project.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/ajaxNoticeSearch.do")
public class AjaxNoticeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxNoticeSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());  //json 형태의 데이터로 변환
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		System.out.println(key + "================");
		System.out.println(val + "================");
		notices = dao.noticeSelectList(key, val);
		String list = objectMapper.writeValueAsString(notices); //list to json
		
		response.setContentType("text/html; charset=UTF-8");  //한글깨짐 방지 text/html 데이터라는 인식
		response.getWriter().append(list);
		return;		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

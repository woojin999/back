package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;

public class producttController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(producttController.class);
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // view -> java 인코딩
		resp.setCharacterEncoding("utf-8"); // java -> view 인코딩
		resp.setContentType("text/html; charset=utf-8"); // 화면출력 담당 브라우저에 전달하는 문자코드 및 형식 지정
		
		String uri = req.getRequestURI();
		log.info(">>> uri > {}", uri);
		String context = req.getContextPath();
		log.info(">>> context > {}", context);
		String path = uri.substring(context.length());
		log.info(">>> path > {}", path);
		path = path.substring(path.lastIndexOf("/")+1);
		
		String destPage = "";
		Action action = null;
		
		switch (path) {
		case "register.pd":
			destPage = "/productt/register.jsp";
			break;

		default:
			break;
		}
	}
	
	
}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.ProductVO;
import service.MemberService;
import service.ProductService;
import service.ProductServiceImpl;



public class ProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(ProductCtrl.class);
	
	private RequestDispatcher rdp;
	private ProductService psv;
	private int isUp;
	private String destPage;
	
	public ProductCtrl() {
		psv = new ProductServiceImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // view -> java 인코딩
		resp.setCharacterEncoding("utf-8"); // java -> view 인코딩
		resp.setContentType("text/html; charset=utf-8"); // 화면출력 담당 브라우저에 전달하는 문자코드 및 형식 지정
		

		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : " + path);
		
		
		switch (path) {
		case "register":
			destPage = "/product/register.jsp";
			break;
		case "insert":
			isUp = psv.register(new ProductVO(
					req.getParameter("pname"),
					Double.parseDouble(req.getParameter("price")),
					req.getParameter("madeby")));
				
			log.info(">>> ProductCtrl > insert > {}", isUp > 0 ? "OK":"Fail");
			destPage = "list.pd";
			break;
		case "list":
			req.setAttribute("list", psv.getList());
			destPage = "/product/list.jsp";
			break;
		case "detail":
			req.setAttribute("pvo", psv.getDetail(Integer.parseInt(req.getParameter("pno"))));
			destPage = "/product/detail.jsp";
			break;
		case "modify":
			req.setAttribute("pvo", psv.getDetail(Integer.parseInt(req.getParameter("pno"))));
			destPage = "/product/modify.jsp";
			break;
		case "update.pd":
			isUp = psv.modify(new ProductVO(Integer.parseInt(req.getParameter("pno")),
					req.getParameter("pname"),
					Double.parseDouble(req.getParameter("price")),
					req.getParameter("madeby")
					));
			log.info(">>> ProductCtrl > Update > {}", isUp > 0 ? "OK":"Fail");
			destPage = "detail.pd?pno="+req.getParameter("pno");
			break;
		case "remove.pd":
			isUp = psv.remove(Integer.parseInt(req.getParameter("pno")));
			log.info(">>> ProductCtrl > Remove > {}", isUp > 0 ? "OK":"Fail");
			destPage = "list.pd";
			break;
		default:
			break;
		}
		RequestDispatcher rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, resp);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}


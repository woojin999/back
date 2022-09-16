package com.myweb.www.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
	
	// 스프링 프레임워크는 실행할 때 @Component로 등록된 모든 클래스를 사전에 인스턴스로 만든다
	// @Component로 인스턴스된 클래스들은 @Inject, @Autowired를 통해 사용할 수 있다
	// DispatcherServlet은 request가 발생하면 분석하기 위해 @requestMapping을 호출한다
	// @requestMapping은 uri값의 패턴에 따라 각 메서드에게 실행주문을 전달한다
		
	private final MemberService msv;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register() {
		// request의 uri 패턴이 같다면 void로 선언 후 그대로 viewResolver에게 전달
		// 해당 uri와 같은 위치의 jsp로 forward된다
		log.info(">>> MemberController > register - GET");
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberVO mvo) {
		log.info(">>> register-mvo : {}", mvo);
		int isUp = msv.register(mvo);
		log.info(">>> member register - post : {}", isUp > 0 ? "OK":"FAIL");
		return "redirect:/";
	}
	@GetMapping("/list") // Springframework 4.3 부터 지원
	public void list(Model model) {
		log.info(">>> member list - get");
		List<MemberVO> list = msv.getList();
		model.addAttribute("list", list);
	}
	@GetMapping("/detail")
	public void detail(Model model, @RequestParam("email") String email) {
		log.info(">>> member detail - get");
		MemberVO mvo = msv.getDetail(email);
		model.addAttribute("mvo", mvo);
	}
	@GetMapping("/modify")
	public void modify(Model model, @RequestParam("email") String email) {
		log.info(">>> member modify - get");
		MemberVO mvo = msv.getDetail(email);
		model.addAttribute("mvo", mvo);
	}
	@PostMapping("/modify")
	public String modify(MemberVO mvo) {		
		int isUp = msv.modify(mvo);
		log.info(">>> member modify - post : {}", isUp > 0 ? "OK":"FAIL");
		return "redirect:/member/detail?email="+mvo.getEmail();
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("email") String email) {
		int isUp = msv.remove(email);
		log.info(">>> member remove - post : {}", isUp > 0 ? "OK":"FAIL");
		return "redirect:/";
	}
	@GetMapping("/login")
	public void login() {
		log.info(">>> member login - get");		
	}
	@PostMapping("/login")
	public String login(MemberVO mvo, HttpSession ses, RedirectAttributes rttr) {
		MemberVO sesMvo = msv.login(mvo);
		if(sesMvo != null) {
			log.info(">>> member login - OK");
			ses.setAttribute("ses", sesMvo);
			ses.setMaxInactiveInterval(10*60); // 10 Min
			rttr.addFlashAttribute("isLogin", 1);
			return "redirect:/";
		}else {
			return "redirect:/member/login";
		}		
	}
	@GetMapping("/logout")
	public String logout(HttpSession ses, RedirectAttributes rttr) {
		ses.removeAttribute("ses"); // ses 라는 이름을 갖는 세션 객체를 삭제
		ses.invalidate();
		rttr.addFlashAttribute("isLogout", 1);
		return "redirect:/";
	}
	
	@ResponseBody
	@PostMapping(value = "/dupleCheck", consumes = "application/json",
				produces = {MediaType.TEXT_PLAIN_VALUE})
	public String dupleCheck(@RequestBody HashMap<String, String> map) {
		// ajax > email : ?
		log.info(">>> {}", map.get("email"));
		int isExist = msv.dupleCheck(map.get("email"));		
		return isExist > 0 ? "1" : "0";
	}
}

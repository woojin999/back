package com.myweb.www.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.ProductVO;
import com.myweb.www.service.ProductService;

@RequestMapping("/product/*")
@Controller
public class ProductController {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Inject
	private ProductService psv;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", psv.getList());
	}
	@GetMapping("/register")
	public void register() {		
	}
	@PostMapping("/register")
	public String register(ProductVO pvo, RedirectAttributes rttr) {
		int isUp = psv.register(pvo);
		return "redirect:/product/list";
	}
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("pno") long pno, Model model) {
		model.addAttribute("pvo", psv.getDetail(pno));		
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") long pno, RedirectAttributes rttr) {
		int isUp = psv.remove(pno);
		return "redirect:/";
	}
	@PostMapping("/modify")
	public String modify(ProductVO pvo, RedirectAttributes rttr) {
		int isUp = psv.modify(pvo);
		return "redirect:/product/detail?pno="+pvo.getPno();
	}
	
}

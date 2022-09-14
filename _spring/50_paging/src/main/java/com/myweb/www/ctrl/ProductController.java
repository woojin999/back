package com.myweb.www.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.ProductService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/product/*")
@Controller
public class ProductController {
		
	@Inject
	private ProductService psv;
	
	@GetMapping("/list")
	public void list(Model model, PagingVO pgvo) {
		model.addAttribute("list", psv.getList(pgvo));
		int totalCount = psv.getTotalCount();
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
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
	public void detail(@RequestParam("pno") long pno, Model model,
		@ModelAttribute("pgvo") PagingVO pgvo) {
		model.addAttribute("pvo", psv.getDetail(pno));
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") long pno, RedirectAttributes rttr, PagingVO pgvo) {
		int isUp = psv.remove(pno);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		return "redirect:/product/list";
	}
	@PostMapping("/modify")
	public String modify(ProductVO pvo, RedirectAttributes rttr, PagingVO pgvo) {
		int isUp = psv.modify(pvo);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		return "redirect:/product/detail?pno="+pvo.getPno();
	}
	
}

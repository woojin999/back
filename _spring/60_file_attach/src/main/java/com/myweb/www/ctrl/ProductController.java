package com.myweb.www.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductDTO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.handler.FileHandler;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/product/*")
@Controller
public class ProductController {
		
	@Inject
	private ProductService psv;
	
	@Inject
	private FileHandler fhd;
	
	@GetMapping("/list")
	public void list(Model model, PagingVO pgvo) {
		model.addAttribute("list", psv.getList(pgvo));
		int totalCount = psv.getTotalCount(pgvo);
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
	}
	@GetMapping("/register")
	public void register() {		
	}
	@PostMapping("/register")
	public String register(ProductVO pvo, RedirectAttributes rttr,
			@RequestParam(name = "fileAttached", required = false) MultipartFile[] files) {
		List<FileVO> fileList = null;
		if(files[0].getSize() > 0) {
			fileList = fhd.getFileList(files);
			pvo.setFileCount(fileList.size());
		}
		int isUp = psv.register(new ProductDTO(pvo, fileList));
		log.info(">>> product register : {}", isUp > 0 ? "OK":"FAIL");
		return "redirect:/product/list";
	}
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("pno") long pno, Model model,
		@ModelAttribute("pgvo") PagingVO pgvo) {
		model.addAttribute("pdto", psv.getDetail(pno));
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") long pno, RedirectAttributes rttr, PagingVO pgvo) {
		int isUp = psv.remove(pno);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		rttr.addAttribute("type", pgvo.getType());
		rttr.addAttribute("kw", pgvo.getKw());
		return "redirect:/product/list";
	}
	@PostMapping("/modify")
	public String modify(
			ProductVO pvo,
			@RequestParam(name="fileAttached", required = false) MultipartFile[] files,
			RedirectAttributes rttr,
			PagingVO pgvo) {
		List<FileVO> fileList = null;
		if(files[0].getSize() > 0) {
			fileList = fhd.getFileList(files);
			pvo.setFileCount(fileList.size());
		}
		int isUp = psv.modify(new ProductDTO(pvo, fileList));
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		rttr.addAttribute("type", pgvo.getType());
		rttr.addAttribute("kw", pgvo.getKw());
		return "redirect:/product/detail?pno="+pvo.getPno();
	}
	@DeleteMapping(value = "/file/{uuid}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> removeFile(@PathVariable("uuid") String uuid){		
		return psv.removeFile(uuid) > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

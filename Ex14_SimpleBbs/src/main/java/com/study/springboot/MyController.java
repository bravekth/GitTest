package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.dto.SimpleBbsDto;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao iSimpleBbsDao;	
	
	@RequestMapping("/")
	// @ResponseBody
	public String root() {
		// return "SimpleBbs 만들기";		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
		model.addAttribute("list", iSimpleBbsDao.listDao());		
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("dto", iSimpleBbsDao.viewDao(id));		
		return "view";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		iSimpleBbsDao.writeDao(request.getParameter("writer"), request.getParameter("title"), request.getParameter("content"));		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/write2", method = RequestMethod.POST)
	public String write2(@RequestParam String writer, @RequestParam String title, @RequestParam String content, Model model) {
		iSimpleBbsDao.writeDao(writer, title, content);		
		return "redirect:list";
	}
	
	@PostMapping("/write3")
	public String write3(SimpleBbsDto simpleBbsDto) {
		iSimpleBbsDao.writeDao2(simpleBbsDto);		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		iSimpleBbsDao.deleteDao(request.getParameter("id"));		
		return "redirect:list";
		
	}
}
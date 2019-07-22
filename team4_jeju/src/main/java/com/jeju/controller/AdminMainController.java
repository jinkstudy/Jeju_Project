package com.jeju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jeju.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin/admin")
public class AdminMainController {
	
	@Autowired
	private AdminServiceImpl adminService;
	
	@RequestMapping(value="{url}.do")
	public String blablabla(@PathVariable String url) {
		return "admin/admin/"+url;
	}	
	
}

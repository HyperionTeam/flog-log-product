package com.pingan.flogp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController extends BaseController{
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		logger.info("This is a message");
		return "abc";
	}
	
}

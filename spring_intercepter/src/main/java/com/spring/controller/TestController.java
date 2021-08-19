package com.spring.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
		@RequestMapping("pre_text")
		public void pre_text() {}
		
		
		@RequestMapping("post_text")
		public void post_test(Model model) {
			model.addAttribute("turn","after_text");
			
		}
		
		@RequestMapping("after_text")
		public void after_test()throws SQLException {
			
			throw new SQLException();
		}
		
		
	
}

package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	/**
	 * 设置初始页面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "admin-index";
	}
	/**
	 * 上传
	 */
	@RequestMapping("/upload")
	public void upload(){
		
	}
}

package com.springdemo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springdemo.domain.dataInstance;
import com.springdemo.impl.DatadealImpl;

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
	public String upload(String data){
		System.out.println("有人往服务器传输数据");
		return "上传成功";
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/person")  
	@ResponseBody
	public String courseSignupListImport(@RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("userName"));

		String pathRoot = "C://Users/lijunyi/git/datadel";
		String path = "";
		if (!uploadfile.isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型
			String contentType = uploadfile.getContentType();
			// 获得文件后缀名称
			String filename = uploadfile.getOriginalFilename();
			String uploadfileType = filename.substring(filename.indexOf(".")+1);
			path = "/file/" + uuid + "." + uploadfileType;
			uploadfile.transferTo(new File(pathRoot + path));
		}
		return "";
	}
	
	@RequestMapping(value="/dealdata")
	@ResponseBody
	public void dealdata(String filename){
		if(filename == null){
			return;
		}
		List<String> res = new ArrayList<>();
		DatadealImpl de = new DatadealImpl();
		
		res = de.getInstanceList(filename);
		List<dataInstance> datalist = de.String2Instance(res);
//		de.savedataInstance(res);
	}
	@Test
	public void test(){
		dealdata("D:/rna.gbk");
	}
}

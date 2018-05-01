package com.springdemo.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.dao.DataBase_Dao;
import com.springdemo.dao.DataFormImpl;
import com.springdemo.dao.FileFormImpl;
import com.springdemo.domain.AfterDataInstance;
import com.springdemo.impl.SingleDatadealImpl;
@Controller
public class DataController {
	static final String FILE_ROOT = "C://Users/lijunyi/git/datadel/file";
	/**
	 * 
	 * @param index 第几页
	 * @return
	 */
	@RequestMapping(value="/getFileForm")
	@ResponseBody
	public List<String> getFileForm(int index, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		File file = new File(FILE_ROOT);
		String[] fileName = file.list();
		List<String> list = Arrays.asList(fileName);
		FileFormImpl ff = new FileFormImpl();
		List<String> res = ff.getFormByIndex(list, index);
		return res;
	}
	
	
	@RequestMapping(value="/getDataForm")
	@ResponseBody
	public List<String> getDataForm(String filename, int index) {
		DataFormImpl ff = new DataFormImpl();
		List<String> res = ff.getDataFormByIndex(filename, index);
		return res;
	}
	
	@RequestMapping(value="/simgledealdata")
	@ResponseBody
	public Map<String,Object> simgledealdataAction(String uuid){
		if(uuid == null){
			return null;
		}
		DataBase_Dao dao = new DataBase_Dao();
		AfterDataInstance adi= dao.getContentById(uuid);
		System.out.println(adi.getOrigin().length());
		SingleDatadealImpl sd  = new SingleDatadealImpl();
		Map<String,Object> map = sd.dealSingledata(adi.getOrigin());
		return map;
	}
	@Test
	public void test(){
		Map<String,Object> map = simgledealdataAction("3d26cae1-be24-4f89-a21d-e1707a8ad691");
	}
}

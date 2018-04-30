package com.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import com.springdemo.domain.Form;

public class FileFormImpl implements Form {
	/**
	 * 每页条数 10页
	 */
	public static final int PAGE=10; 
	@Override
	public List<String> getFormByIndex(List<String> list, int index) {
		if (list.size() <= 10 || list.size() % PAGE < index) {
			return list;
		}
		List<String> res = new ArrayList<>();
		for(int i=index*10;i<index*10+10;i++){
			res.add(list.get(i));
		}
		return res;
	}

}

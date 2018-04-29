package com.springdemo.dao;

import java.util.List;

import com.springdemo.domain.DataForm;

public class DataFormImpl implements DataForm {

	@Override
	public List<String> getDataFormByIndex(String filename, int index) {
		DataBase_Dao dao =new DataBase_Dao();
		List<String> res = dao.getDataFormByIndex(filename,index);
		return res;
	}


}

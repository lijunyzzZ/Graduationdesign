package com.springdemo.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.springdemo.dao.DataBase_Dao;
import com.springdemo.dao.Datadeal;
import com.springdemo.domain.*;
/**
 * 数据处理实现类
 * @author 李君易
 *
 */
public class DatadealImpl implements Datadeal{

	@Override
	public List<String> getInstanceList(String filename) {
		if(filename == null){
			return null;
		}
		File file = new File(filename); 
		if(file == null){
			System.err.println("文件找不到位置！");
			return null;
		}
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 建立数据通道
		int length = 0;
		int i = 0;
		byte[] buf = new byte[204800];// 建立缓存数组，缓存数组的大小一般都是1024的整数倍，理论上越大效率越好
		byte[] surplusBuf = null;
		List<String> res = new ArrayList<>();
		try {
			while ((length = fileInputStream.read(buf)) != -1) {
//			System.out.print(new String(buf, 0, length));
				// 这里写个方法 将余数组和当前数组集合在一起分隔成对象数组
				IndirectData indirectData = GetInstanceByBuf(buf, surplusBuf);
				res.addAll(indirectData.getInstanceString());
				surplusBuf = indirectData.getSurplus();
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 关闭资源
		return res;
	}

	@Override
	public List<AfterDataInstance> getAfterDataInstance(List<dataInstance> list) {
		DataBase_Dao a = new DataBase_Dao();
		return a.getDao();
	}

	@Override
	public void savedataInstance(List<String> res){
		List<dataInstance> datalist = String2Instance(res);
		DataBase_Dao a = new DataBase_Dao();
		a.saveDaos1(datalist);
	}

	@Override
	public void saveAfterDataInstance(List<AfterDataInstance> res) {
		//TODO
	}

	@Override
	public IndirectData GetInstanceByBuf(byte[] buf, byte[] surplus) {
		byte[] mergeByte = getMergeByte(buf, surplus);
		String longa = new String(mergeByte, 0, mergeByte.length);
		List<String> resString = new ArrayList<>();
		String str[] = longa.split("//");
		byte[] sur = null;
		if (str[str.length - 1].indexOf("//") == -1) {
			list2String(resString, str, str.length - 1);
			sur = str[str.length - 1].getBytes();
		}else{
			list2String(resString, str, str.length);
		}
		IndirectData indirectData = new IndirectData(resString, sur);
		return indirectData;
	
	}
	
	public byte[] getMergeByte(byte[] buf, byte[] surplus) {
		if (surplus == null) {
			return buf;
		}
		byte[] data3 = new byte[buf.length + surplus.length];
		System.arraycopy(surplus, 0, data3, 0, surplus.length);
		System.arraycopy(buf, 0, data3, surplus.length, buf.length);
		return data3;

	}
	
	
	public void list2String(List<String> s, String[] str, int len) {
		if (str.length == 0) {
			return;
		}
		for (int i = 0; i < len; i++) {
			s.add(str[i]);
		}
	}
	public List<dataInstance> String2Instance(List<String> res) {

		List<dataInstance> datalist = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			dataInstance dataInstance = new dataInstance(res.get(i));
			datalist.add(dataInstance);
		}
		return datalist;
	
	}

}

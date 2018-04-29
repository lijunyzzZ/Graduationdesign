package com.springdemo.dao;

import com.springdemo.domain.IndirectData;
import com.springdemo.domain.*;
import java.util.List;

/**
 * 数据处理接口
 * @author 李君易
 *
 */
public interface Datadeal {
	/**
	 * 从文本之中读取数据
	 * @param filename
	 * @return
	 */
	public List<String> getInstanceList(String filename);
//		if(filename == null)
//			return null;
//		List<dataInstance> res = =
//		return res;
//	};
	/**
	 * 获取处理后的数据
	 * @param list
	 * @return
	 */
	public List<AfterDataInstance> getAfterDataInstance(List<dataInstance> list);
	/**
	 * 保存处理前的数据到数据库
	 * @param res
	 */
	public void savedataInstance(List<dataInstance> res);
	/**
	 * 保存处理后的数据到数据库
	 * @param res
	 */
	public void saveAfterDataInstance(List<AfterDataInstance> res);
	
	/**
	 * 转化数据缓存方法
	 * @param buf
	 * @param surplus
	 * @return
	 */
	public IndirectData GetInstanceByBuf(byte[] buf, byte[] surplus);
	
	public byte[] getMergeByte(byte[] buf, byte[] surplus);
	
	public void list2String(List<String> s, String[] str, int len);
	
	public List<dataInstance> String2Instance(List<String> res,String filename);
}

package com.springdemo.domain;

import java.util.List;

/**
 * 处理返回列表的接口
 *	
 * @author 李君易
 *
 */
public interface Form {
	public List<String> getFormByIndex(List<String> list, int index);
}

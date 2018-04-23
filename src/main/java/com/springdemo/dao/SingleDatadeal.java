package com.springdemo.dao;

import java.util.List;

public interface SingleDatadeal {
	public void dealData();

	public String deal(String a, StringBuffer sb);

	public String[] StringSplitArr(String str, int n);

	public boolean contain(String[] str, String s);

	public int containInt(String[] str, String s);

	public String getResStr(String[] s, int start, int end, StringBuffer sb);

	public int initiator(int n, String[] str);

	public int terminator(int n, String[] str);

	public void deal(String[] str);

	public void deal1(String[] str);

	public List<String> getDataRes(String[] s);

}

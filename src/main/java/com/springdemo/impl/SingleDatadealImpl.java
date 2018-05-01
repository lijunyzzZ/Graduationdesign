package com.springdemo.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.springdemo.domain.*;
import com.mysql.jdbc.StringUtils;
import com.springdemo.commons.stringUtil;
import com.springdemo.dao.DataBase_Dao;
import com.springdemo.dao.SingleDatadeal;

public class SingleDatadealImpl implements SingleDatadeal {
	static final String[] ATCG = {"a","t","c","g"};
	@Override
	public void dealData() {
		DataBase_Dao a = new DataBase_Dao();
		List<AfterDataInstance> res = null;
		res = a.getDao();
		StringBuffer sb = new StringBuffer(64);
		AfterDataInstance data = null;
		int size = res.size();
		if (size > 0) {
			System.err.println("数据库没有数据");
			return;
		}
		for (int i = 0; i < size; i++) {
			data = res.get(i);
			data.setOrigin(deal(data.getOrigin(), sb));
		}

	}

	@Override
	public String deal(String a, StringBuffer sb) {
		sb.setLength(0);
		sb.append(a);
		if (sb.indexOf("atg") == -1 || (sb.indexOf("") == -1 && sb.indexOf("") == -1 && sb.indexOf("") == -1)) {
			return "";
		}

		return "";
	}

	@Override
	public String[] StringSplitArr(String str, int n) {
		String[] res = new String[str.length() / n];
		for (int i = 0; i < res.length; i++) {
			res[i] = str.substring(i, i + n);
		}
		return res;
	}

	@Override
	public boolean contain(String[] str, String s) {
		if (str.length == 0 || s == null || s.equals("")) {
			return false;
		}
		for (int i = 0; i < str.length; i++) {
			if (s.equals(str[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int containInt(String[] str, String s) {
		if (str.length == 0 || s == null || s.equals("")) {
			return -1;
		}
		for (int i = 0; i < str.length; i++) {
			if (s.equals(str[i])) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		return -1;
	}

	@Override
	public String getResStr(String[] s, int start, int end, StringBuffer sb) {
		if (start > end || end > s.length || start < 0 || end < 0) {
			return "";
		}
		sb.setLength(0);
		for (int i = start; i < end; i++) {
			sb.append(s[i]);
		}
		return sb.toString();
	}

	@Override
	public int initiator(int n, String[] str) {
		if (str.length == 0) {
			return -1;
		}
		for (int i = n; i < str.length; i++) {
			if (str[i].equals("atg")) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int terminator(int n, String[] str) {
		if (str.length == 0) {
			return -1;
		}
		for (int i = n; i < str.length; i++) {
			if (str[i].equals("tga") || str[i].equals("tag") || str[i].equals("taa")) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void deal(String[] str) {
		if (contain(str, "ATG") && (contain(str, "TGA") || contain(str, "TAG") || contain(str, "TAA"))) {
			deal1(str);
		}

	}

	@Override
	public void deal1(String[] str) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getDataRes(String[] s) {
		int start = 0;
		int end = 0;
		List<String> res = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		while (end < s.length) {
			start = initiator(start, s);
			if(start ==-1){
				break;
			}
			end = terminator(start, s);
			res.add(getResStr(s, start, end, sb));
			start = end;
			
		}
		return res;
	}
	
	@Test
	public void Test() throws IOException {
		String fileName = "D:/ab.txt";
		File file = new File(fileName); // 找到目标文件
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // 建立数据通道
		int length = 0;
		int i = 0;
		byte[] buf = new byte[204800];// 建立缓存数组，缓存数组的大小一般都是1024的整数倍，理论上越大效率越好
		StringBuffer s = new StringBuffer();
		while ((length = fileInputStream.read(buf)) != -1) {
			s.append(new String(buf, 0, length));

		}
		fileInputStream.close();
		String a = s.toString();
		stringUtil st = new stringUtil();
		dataInstance di = new dataInstance("","");
		a = di.dealOrign(a);
		a = st.translation(a);
		System.out.println(a.length());
		StringBuffer sb = new StringBuffer(64);
		deal(a, sb);
		String[] b = StringSplitArr(a, 3);
		List<String> res = getDataRes(b);
		System.out.println(res.size());
		for(int j=0;j<res.size();j++){
			System.out.print(res.get(j));
			System.out.println();
		}

	}

	@Override
	public Map<String, Object> dealSingledata(String data) {
		String cl = new String(data);
		float lengthbefore = data.length();
		List<String> res = splitContent(cl);
		Map<String, Object> result = new HashMap<>();
		float lengthAfter = 0;
		List<Object> floatArrList = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			lengthAfter = lengthAfter + res.get(i).length();
			floatArrList.add(getPercentArrByres(data));
		}
		result.put("lenPercent", lengthAfter / lengthbefore);
		result.put("contentList", res);
		result.put("floatArrList", floatArrList);
		return result;
	}

	private float[] getPercentArrByres(String data) {
		int len = data.length();
		if (len == 0) {
			return null;
		}
		float[] res = new float[4];
		for (int i = 0; i < res.length; i++) {
			res[i] = getPercent(data, ATCG[i]);
		}
		return res;

	}

	private float getPercent(String data, String index) {
		float len = data.length();
		if (len == 0) {
			return 0;
		}
		float reslen = len - data.replaceAll(index, "").length();
		float a = reslen / len;
		return a;
	}
	/**
	 * 将origin中的有效的字符串拆分出来
	 * @param origin
	 * @return
	 */
	@Override
	public List<String> splitContent(String origin) {
		System.out.println("拆分开始");
		dataInstance di = new dataInstance("", "");
		origin = di.dealOrign(origin);
		stringUtil st = new stringUtil();
		origin = st.translation(origin);
		System.out.println(origin.length());
		StringBuffer sb = new StringBuffer(64);
		deal(origin, sb);
		String[] b = StringSplitArr(origin, 3);
		List<String> res = getDataRes(b);
		System.out.println("拆分结束");
		return res;
	}

	@Override
	public List<Map<String, String>> dealSingledatas(List<String> data) {
		List<Map<String, String>> res = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
//			Map<String, String> r = dealSingledata(data.get(i));
//			res.add(r);
		}
		return res;
	}
	@Test
	public void test(){
		String data= "aaaattttcccgggg";
		float a[] = getPercentArrByres(data);
		System.out.println();
	}
}

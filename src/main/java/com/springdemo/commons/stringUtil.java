package com.springdemo.commons;
/**
 * string compress
 * 
 * @author 李君易
 *
 */
public class stringUtil {

	public String translation(String str){
		if(str == null){
			return "";
		}
		String s = str.replaceAll(" ", "")
		.replaceAll("'", "")
		.replaceAll("/", "")
		.replaceAll("\\[", "")
		.replaceAll("///]", "")
		.replaceAll("//%", "")
		.replaceAll("&", "")
		.replaceAll("_", "")
		.replaceAll("\\(", "")
		.replaceAll("\\)", "")
		.replaceAll("-", "")
		.replaceAll("\n", "")
		.replaceAll("\\.", "")
		.replaceAll("\"", "")
		.replaceAll(";", "")
		.replaceAll(":", "")
		.replaceAll(",", "");
		return s;
	}

}

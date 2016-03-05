/**
 * @author elvis.zhang
 * Description: 
 * 将多个字符初始化为String
 * 2016年3月5日下午1:39:51
 */
package com.ralvis.cashier.utils;

public class MultiChars {
	
	public static String initToString(int repeatTimes, char ch) {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < repeatTimes; i++) {
			buffer.append(ch);
		}
		return buffer.toString();
	}
}

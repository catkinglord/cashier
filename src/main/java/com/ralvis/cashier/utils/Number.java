 /**
 * @author elvis.zhang
 * Description: 
 * 数字帮助类
 * 2016年3月11日下午2:56:24
 */
package com.ralvis.cashier.utils;

import java.util.HashMap;
import java.util.Map;

public class Number {
	private static Map<Integer, String> maps = new HashMap<>();
	private static char[] characters = {'一', '二', '三', 
		'四', '五', '六', '七',
		'八', '九', '十'};
	static {
		for(int i = 0; i < characters.length; i++) {
			maps.put(i + 1, String.valueOf(characters[i]));
		}
	}
	
	public static String getCharacter(int number) {
		if (number < 1 || number > 10) {
			throw new RuntimeException("只能支持1-10以内的数字");
		}
		return maps.get(number);
	}
}

/**
 * @author elvis.zhang
 * Description: 
 * 打印小票-输出名称格式-例如-名称: 苹果
 * 2016年3月5日下午4:03:09
 */
package com.ralvis.cashier.print.printer;

import org.apache.commons.lang.StringUtils;

public class KeyValuePrinter implements Printer{
	private final static String UNKONW_VALUE = "未知";
	
	private String key;
	private String value;
	
	public KeyValuePrinter(String key, String value) {
		this.key = key;
		this.value = value;
		if (StringUtils.isEmpty(key)) {
			throw new RuntimeException("key不能为空");
		}
		if (StringUtils.isEmpty(value)) {
			this.value = UNKONW_VALUE;
		}
	}
	
	@Override
	public String print() {
		return String.format("%s：%s", key, value);
	}

}

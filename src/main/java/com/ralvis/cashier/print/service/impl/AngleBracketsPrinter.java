/**
 * @author elvis.zhang
 * Description: 
 * 打印小票-尖括号输出名称
 * 2016年3月5日下午3:38:03
 */
package com.ralvis.cashier.print.service.impl;

import org.apache.commons.lang.StringUtils;

import com.ralvis.cashier.print.service.Printer;

public class AngleBracketsPrinter implements Printer{

	private String name;
	
	public AngleBracketsPrinter(String name) {
		this.name = name;
	}
	
	@Override
	public String print() {
		if (StringUtils.isEmpty(name)) {
			return "";
		}
		return String.format("<%s>", this.name);
	}
}

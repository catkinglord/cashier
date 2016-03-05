/**
 * @author elvis.zhang
 * Description: 
 * 打印小票-输出名称数量单位格式-例如-数量: 2斤
 * 2016年3月5日下午4:40:35
 */
package com.ralvis.cashier.print.printer;

import org.apache.commons.lang.StringUtils;

public class KeyAmountWithUomPrinter implements Printer{
	private static final String UNKONW_UOM = "";
	
	private String key;
	//数量
	private int amount;
	//单位
	private String uom;
	
	public KeyAmountWithUomPrinter(String key, int amount, String uom) {
		this.key = key;
		this.amount = amount;
		this.uom = uom;
		if (StringUtils.isEmpty(key)) {
			throw new RuntimeException("key不能为空");
		}
		if (amount <= 0) {
			throw new RuntimeException("数量必须为正数");
		}
		if (StringUtils.isEmpty(uom)) {
			this.uom = UNKONW_UOM;
		}
	}
	
	@Override
	public String print() {
		return String.format("%s：%d%s", key, amount, uom);
	}

}

/**
 * @author elvis.zhang
 * Description: 
 * 打印小票-输出名称金额单位格式-例如-单价: 2.00(元)
 * 2016年3月5日下午5:19:20
 */
package com.ralvis.cashier.print.printer;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class KeyMoneyWithUomPrinter implements Printer{
	private static final String UNKONW_UOM = "元";
	
	private String key;
	//数量
	private BigDecimal money;
	//小数点位数
	private int decimals;
	//单位
	private String uom;
	
	public KeyMoneyWithUomPrinter(String key, BigDecimal money, int decimals, String uom) {
		this.key = key;
		this.money = money;
		this.decimals = decimals;
		this.uom = uom;
		if (StringUtils.isEmpty(key)) {
			throw new RuntimeException("key不能为空");
		}
		if (money == null || money.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("金额必须为正数");
		}
		if (decimals < 0) {
			throw new RuntimeException("金额小数点位数必须大于0");
		}
		if (StringUtils.isEmpty(uom)) {
			this.uom = UNKONW_UOM;
		}
	}
	
	@Override
	public String print() {
		String moneyFormat = String.format("%%.%df", decimals);
		String format = String.format("%%s：%s(%%s)", moneyFormat);
		return String.format(format, key, money.doubleValue(), uom);
	}
}

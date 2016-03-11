/**
 * @author elvis.zhang
 * Description:
 * 商品打印的明细的有关于money的固定值 
 * 2016年3月11日下午12:10:18
 */
package com.ralvis.cashier.print.lineprinter;

public interface ItemMoneyKey {
	//金额单位
	String getMoneyUom();
	//金额的小数点位数
	int getMoneyDecimal();
}

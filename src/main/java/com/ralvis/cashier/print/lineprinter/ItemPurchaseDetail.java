/**
 * @author elvis.zhang
 * Description: 
 * 用户购买的一条商品详情，包括名称，数量，单价，小计
 * 2016年3月5日下午6:38:06
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;

public interface ItemPurchaseDetail {

	//商品名称
	String getNameKey();
	String getNameValue();
	
	//数量
	String getAmountKey();
	int getAmount();
	String getAmountUom();
	
	//单价
	String getUnitPriceKey();
	BigDecimal getUnitPriceMoney();
	String getMoneyUom();
	
	//小计
	String getTotalKey();
	BigDecimal getTotalMoney();
	//金额的小数点位数
	int getMoneyDecimal();
}

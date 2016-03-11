/**
 * @author elvis.zhang
 * Description: 
 * 用户购买的一条商品详情，包括名称，数量，单价，小计
 * 2016年3月5日下午6:38:06
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;

public interface ItemPurchaseDetail extends ItemDetailKey{

	//商品名称
	String getNameValue();
	
	//数量
	int getAmount();
	String getAmountUom();
	
	//单价
	BigDecimal getUnitPriceMoney();
	String getMoneyUom();
	
	//小计
	BigDecimal getTotalMoney();
}

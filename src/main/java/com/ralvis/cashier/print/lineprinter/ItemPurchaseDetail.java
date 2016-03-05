/**
 * @author elvis.zhang
 * Description: 
 * 用户购买的一条商品详情，包括名称，数量，单价，小计
 * 2016年3月5日下午6:38:06
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;

public interface ItemPurchaseDetail {

	String getNameKey();
	//商品名称
	String getNameValue();
	
	String getAmountKey();
	//数量
	int getAmount();
	String getAmountUom();
	
	String getUnitPriceKey();
	//单价
	BigDecimal getUnitPriceMoney();
	String getMoneyUom();
	
	String getTotalKey();
	//小计
	BigDecimal getTotalMoeny();
	
	
	String getSavedKey();
	//节省的钱
	BigDecimal getSavedMoney();
	
	//金额的小数点位数
	int getMoneyDecimal();
}

/**
 * @author elvis.zhang
 * Description: 
 * 用户购买的一条商品详情，包括名称，数量，单价，小计，节省
 * 2016年3月6日上午9:41:06
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;

public interface ItemPurchaseDetailWithSavedMoney extends ItemPurchaseDetail  {

	//节省的钱
	String getSavedKey();
	BigDecimal getSavedMoney();
}

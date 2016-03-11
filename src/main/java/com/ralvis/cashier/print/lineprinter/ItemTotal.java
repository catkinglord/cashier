 /**
 * @author elvis.zhang
 * Description: 
 * 商品总计抽象类
 * 2016年3月11日上午11:43:24
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;

public interface ItemTotal {

	String getItemTotalKey();
	BigDecimal getItemTotalMoney();
	
	String getMoneyUom();
	//金额的小数点位数
	int getMoneyDecimal();
}

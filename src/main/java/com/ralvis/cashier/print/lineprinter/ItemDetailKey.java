 /**
 * @author elvis.zhang
 * Description: 
 * 商品打印的明细的相对固定值，需要系统配置，例如名称，数量，小计，总结，节省等
 * 2016年3月11日上午11:28:42
 */
package com.ralvis.cashier.print.lineprinter;

public interface ItemDetailKey {

	//商品名称key
	String getNameKey();
	//商品数量key
	String getAmountKey();
	//商品单价key
	String getUnitPriceKey();
	//商品总价key
	String getTotalKey();
	//金额的小数点位数
	int getMoneyDecimal();
}

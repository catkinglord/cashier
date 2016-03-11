/**
 * @author elvis.zhang
 * Description: 
 * 商品名称，数量抽象接口
 * 2016年3月11日上午10:46:52
 */
package com.ralvis.cashier.print.lineprinter;

public interface ItemFreeAmountDetail {
	//商品名称
	String getNameKey();
	String getNameValue();

	//优惠数量
	String getAmountKey();
	int getFreeAmount();
	String getAmountUom();
}

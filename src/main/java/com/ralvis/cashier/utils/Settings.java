 /**
 * @author elvis.zhang
 * Description: 
 * 系统的全局设置
 * 2016年3月8日下午5:27:26
 */
package com.ralvis.cashier.utils;

import java.math.BigDecimal;

public class Settings {

	/**
	 * 购买商品的数量限制
	 * @param amount
	 */
	public static void checkBuyAmountCondition(int amount) {
		if (amount <= 0) {
			throw new RuntimeException("数量不能为负数");
		}
	}
	
	/**
	 * 购买商品的单价限制
	 * @param amount
	 */
	public static void checkBuyUnitPriceCondition(BigDecimal unitPrice) {
		if( unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("单价只能为正数");
		}
	}
	
}

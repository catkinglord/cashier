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
	
	/**
	 * 打印商品名称的key值
	 */
	public static String getNameKey() {
		return "名称";
	}
	/**
	 * 打印商品数量的key值
	 */
	public static String getAmountKey() {
		return "数量";
	}
	/**
	 * 打印商品单价的key值
	 */
	public static String getUnitPriceKey() {
		return "单价";
	}
	/**
	 * 打印商品金额单位
	 */
	public static String getMoneyUom() {
		return "元";
	}
	/**
	 * 打印商品小计的key值
	 */
	public static String getItemDetailTotalKey() {
		return "小计";
	}
	/**
	 * 打印商品金额的小数点位数
	 */
	public static int getMoneyDecimal() {
		return 2;
	}
	/**
	 * 打印商品节省的key值
	 */
	public static String getItemSavedKey() {
		return "节省";
	}
	/**
	 * 打印商品总计的key值
	 */
	public static String getItemsTotalKey() {
		return "总计";
	}
	
}

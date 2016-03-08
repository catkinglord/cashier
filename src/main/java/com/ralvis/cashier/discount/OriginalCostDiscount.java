 /**
 * @author elvis.zhang
 * Description: 
 * 商品按照原价计算，不享受折扣
 * 2016年3月8日下午4:08:33
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;

public class OriginalCostDiscount implements Discount{

	@Override
	public BigDecimal compute(int amount, BigDecimal unitPrice) {
		if (amount <= 0) {
			throw new RuntimeException("数量不能为负数 ");
		}
		if( unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("单价只能为正数");
		}
		
		return unitPrice.multiply(BigDecimal.valueOf(amount));
	}
}

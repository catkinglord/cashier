 /**
 * @author elvis.zhang
 * Description: 
 * 商品享受固定折扣, 例如95折
 * 2016年3月8日下午4:21:45
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;

public class NormalDiscount extends OriginalCostDiscount implements SavedMoney{
	private static final int MIN_DISCOUNT = 1;
	private static final int MAX_DISCOUNT = 100;
	private static final BigDecimal BIGDECIMAL_100 = BigDecimal.valueOf(100);
	
	private int discount;
	
	public NormalDiscount(int discount) {
		this.discount = discount;
		if (discount < MIN_DISCOUNT) {
			throw new RuntimeException(String.format("折扣不能小于%d", MIN_DISCOUNT));
		}
		if (discount >= MAX_DISCOUNT) {
			throw new RuntimeException(String.format("折扣不能大于%d", MAX_DISCOUNT));
		}
	}
	
	/**
	 * 技术折扣商品省的钱
	 */
	public BigDecimal computeSavedMoney(int amount, BigDecimal unitPrice) {
		return super.compute(amount, unitPrice)
				.multiply(BIGDECIMAL_100.subtract(BigDecimal.valueOf(discount)))
				.divide(BIGDECIMAL_100);
	}
	
	@Override
	public BigDecimal compute(int amount, BigDecimal unitPrice) {
		return super.compute(amount, unitPrice)
				.multiply(BigDecimal.valueOf(discount))
				.divide(BIGDECIMAL_100);
	}
}

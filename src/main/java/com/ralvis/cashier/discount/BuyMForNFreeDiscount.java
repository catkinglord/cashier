 /**
 * @author elvis.zhang
 * Description: 
 * 商品享受买M赠N的优惠, 例如买二赠一
 * 2016年3月8日下午4:54:48
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;

public class BuyMForNFreeDiscount extends OriginalCostDiscount {
	//购买数
	private int mBuy;
	//赠送数
	private int nFree;
	
	public BuyMForNFreeDiscount(int mBuy, int nFree) {
		this.mBuy = mBuy;
		this.nFree = nFree;
		if (mBuy <= 0) {
			throw new RuntimeException("最小购买数必须为正数");
		}
		if (nFree <= 0) {
			throw new RuntimeException("最小赠送数必须为正数");
		}
		if (mBuy <= nFree) {
			throw new RuntimeException("购买数必须大于赠送数");
		}
	}
	
	@Override
	public BigDecimal compute(int amount, BigDecimal unitPrice) {
		int actualPaidAmount = getActualPaidAmount(amount);
		return super.compute(actualPaidAmount, unitPrice);
	}
	int getActualPaidAmount(int amount) {
		if (amount < mBuy) {
			return amount;
		}
		return amount - (amount / mBuy) * nFree;
	}
}

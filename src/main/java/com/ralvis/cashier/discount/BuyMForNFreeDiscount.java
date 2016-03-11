 /**
 * @author elvis.zhang
 * Description: 
 * 商品享受买M赠N的优惠, 例如买二赠一
 * 2016年3月8日下午4:54:48
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;

public class BuyMForNFreeDiscount extends OriginalCostDiscount implements SavedMoney{
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
	
	/**
	 * 免费赠送的商品个数
	 */
	public int costFreeNumber(int amount) {
		return amount / (mBuy + nFree) * (mBuy - nFree);
	}
	
	@Override
	public BigDecimal compute(int amount, BigDecimal unitPrice) {
		int actualPaidAmount = getActualPaidAmount(amount);
		return super.compute(actualPaidAmount, unitPrice);
	}
	int getActualPaidAmount(int amount) {
		return amount - costFreeNumber(amount);
	}

	@Override
	public BigDecimal computeSavedMoney(int amount, BigDecimal unitPrice) {
		int freeNumber = costFreeNumber(amount);
		//freeNumber可能为0, 比如买2赠1，只买了2个
		return unitPrice.multiply(BigDecimal.valueOf(freeNumber));
	}
}

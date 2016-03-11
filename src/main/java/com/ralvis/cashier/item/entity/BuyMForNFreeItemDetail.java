 /**
 * @author elvis.zhang
 * Description: 
 * 购买的买M送N的商品
 * 2016年3月11日上午10:41:49
 */
package com.ralvis.cashier.item.entity;

import com.ralvis.cashier.discount.BuyMForNFreeDiscount;
import com.ralvis.cashier.print.lineprinter.ItemFreeAmountDetail;

public class BuyMForNFreeItemDetail extends ItemDetail implements ItemFreeAmountDetail{
	private int freeAmount;
	
	public BuyMForNFreeItemDetail(Item item, int amount, BuyMForNFreeDiscount discount) {
		super(item, amount, discount);
		
		freeAmount = discount.costFreeNumber(amount);
	}
	
	@Override
	public int getFreeAmount() {
		return freeAmount;
	}
}

 /**
 * @author elvis.zhang
 * Description: 
 * 购买的买M送N的商品
 * 2016年3月11日上午10:41:49
 */
package com.ralvis.cashier.item.entity;

import java.math.BigDecimal;

import com.ralvis.cashier.discount.BuyMForNFreeDiscount;
import com.ralvis.cashier.print.lineprinter.ItemDetailLinePrinter;
import com.ralvis.cashier.print.lineprinter.ItemFreeAmountDetail;
import com.ralvis.cashier.print.lineprinter.ItemPurchaseDetailWithSavedMoney;
import com.ralvis.cashier.print.lineprinter.LinePrinter;
import com.ralvis.cashier.setting.Settings;

public class BuyMForNFreeItemDetail extends ItemDetail implements ItemFreeAmountDetail, ItemPurchaseDetailWithSavedMoney {
	private int freeAmount;
	private BigDecimal savedMoney;
	
	public BuyMForNFreeItemDetail(Item item, int amount, BuyMForNFreeDiscount discount) {
		super(item, amount, discount);
		
		freeAmount = discount.costFreeNumber(amount);
		savedMoney = discount.computeSavedMoney(amount, item.getUnitPrice());
	}
	
	@Override
	public LinePrinter generateLinePrinter() {
		return new ItemDetailLinePrinter(this);
	}
	
	@Override
	public int getFreeAmount() {
		return freeAmount;
	}

	@Override
	public String getSavedKey() {
		return Settings.getItemSavedKey();
	}

	@Override
	public BigDecimal getSavedMoney() {
		return savedMoney;
	}
}

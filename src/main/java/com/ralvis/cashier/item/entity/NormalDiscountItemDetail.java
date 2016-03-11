 /**
 * @author elvis.zhang
 * Description: 
 * 购买的折扣商品
 * 2016年3月9日下午1:45:58
 */
package com.ralvis.cashier.item.entity;

import java.math.BigDecimal;

import com.ralvis.cashier.discount.NormalDiscount;
import com.ralvis.cashier.print.lineprinter.ItemPurchaseDetailWithSavedMoney;
import com.ralvis.cashier.utils.Settings;

public class NormalDiscountItemDetail extends ItemDetail implements ItemPurchaseDetailWithSavedMoney{
	private NormalDiscount normalDiscount;
	private BigDecimal savedMoney;
	
	/**
	 * @param item
	 * @param amount
	 * @param discount
	 */
	public NormalDiscountItemDetail(Item item, int amount, NormalDiscount discount) {
		super(item, amount, discount);
		if (discount == null) {
			throw new RuntimeException("discount不能为空");
		}
		this.normalDiscount = discount;
		savedMoney = normalDiscount.computeSavedMoney(amount, item.getUnitPrice());
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

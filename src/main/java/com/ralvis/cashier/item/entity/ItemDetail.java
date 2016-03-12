 /**
 * @author elvis.zhang
 * Description: 
 * 购买的商品明细
 * 2016年3月9日下午12:59:35
 */
package com.ralvis.cashier.item.entity;

import java.math.BigDecimal;
import com.ralvis.cashier.discount.Discount;
import com.ralvis.cashier.discount.OriginalCostDiscount;
import com.ralvis.cashier.print.lineprinter.ItemDetailKeyFromSettings;
import com.ralvis.cashier.print.lineprinter.ItemPurchaseDetail;

public abstract class ItemDetail extends ItemDetailKeyFromSettings implements 
					ItemPurchaseDetail, LinePrinterGenerator {
	//商品品种
	protected Item item;
	//商品数量
	protected int amount;
	//商品总价
	protected BigDecimal total;
	//打折接口
	protected Discount discount;
	
	public ItemDetail(Item item, int amount, Discount discount) {
		if (discount == null) {
			throw new RuntimeException("discount不能为空");
		}
		init(item, amount, discount);
	}
	
	public ItemDetail(Item item, int amount) {
		init(item, amount, new OriginalCostDiscount());
	}
	
	private void init(Item item, int amount, Discount discount) {
		this.item = item;
		this.amount = amount;
		this.discount = discount;
		
		if (item == null) {
			throw new RuntimeException("item不能为空");
		}
		if (amount <= 0) {
			throw new RuntimeException("购买的item数量要为正数");
		}
		this.total = discount.compute(amount, item.getUnitPrice());
	}

	@Override
	public String getNameValue() {
		return item.getItemName();
	}

	@Override
	public int getAmount() {
		return amount;
	}
	
	@Override
	public String getAmountUom() {
		return item.getAmountUom();
	}

	@Override
	public BigDecimal getUnitPriceMoney() {
		return item.getUnitPrice();
	}

	@Override
	public BigDecimal getTotalMoney() {
		return total;
	}
	
	public Discount getDiscount() {
		return discount;
	}
}

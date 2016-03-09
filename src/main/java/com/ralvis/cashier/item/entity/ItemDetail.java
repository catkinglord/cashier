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

public class ItemDetail {
	//商品品种
	private Item item;
	//商品数量
	private int amount;
	//商品总价
	private BigDecimal total;
	//打折接口
	private Discount discount;
	
	public ItemDetail(Item item, int amount, Discount discount) {
		this.item = item;
		this.amount = amount;
		this.discount = discount;
		
		if (item == null) {
			throw new RuntimeException("item不能为空");
		}
		if (amount <= 0) {
			throw new RuntimeException("购买的item数量要为正数");
		}
		if (discount == null) {
			discount = new OriginalCostDiscount();
		}
		this.total = discount.compute(amount, item.getUnitPrice());
	}
}

 /**
 * @author elvis.zhang
 * Description: 
 * 优惠通用接口
 * 2016年3月8日下午4:03:42
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;

import com.ralvis.cashier.item.entity.Item;
import com.ralvis.cashier.item.entity.ItemDetail;

public interface Discount {

	/**
	 * 计算商品总价格
	 * @param amount 	商品数量
	 * @param unitPrice 单价
	 * @return			总价
	 */
	BigDecimal compute(int amount, BigDecimal unitPrice);
	
	ItemDetail generateItemDetail(Item item, int amount);
}

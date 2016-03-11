 /**
 * @author elvis.zhang
 * Description: 
 * 创建折扣类
 * 2016年3月11日下午5:18:11
 */
package com.ralvis.cashier.setting;

import com.ralvis.cashier.discount.BuyMForNFreeDiscount;
import com.ralvis.cashier.discount.Discount;
import com.ralvis.cashier.discount.NormalDiscount;
import com.ralvis.cashier.discount.OriginalCostDiscount;

public class DiscountFacotory {

	public static Discount NORMAL_DISCOUNT = new NormalDiscount(Settings.getNormalDiscount());
	public static Discount ORIGINAL_DISCOUNT = new OriginalCostDiscount();
	public static Discount MFORNFREE_DISCOUNT = new BuyMForNFreeDiscount(Settings.getBuyM(),
			Settings.getFreeN());
}

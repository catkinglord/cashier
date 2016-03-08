 /**
 * @author elvis.zhang
 * Description: 
 * 商品按照原价计算，不享受折扣
 * 2016年3月8日下午4:08:33
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;
import com.ralvis.cashier.utils.Settings;

public class OriginalCostDiscount implements Discount {

	@Override
	public BigDecimal compute(int amount, BigDecimal unitPrice) {
		Settings.checkBuyAmountCondition(amount);
		Settings.checkBuyUnitPriceCondition(unitPrice);
		return unitPrice.multiply(BigDecimal.valueOf(amount));
	}
}

 /**
 * @author elvis.zhang
 * Description: 
 * 省钱的抽象接口
 * 2016年3月11日下午3:15:52
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;

public interface SavedMoney {

	public BigDecimal computeSavedMoney(int amount, BigDecimal unitPrice);
}

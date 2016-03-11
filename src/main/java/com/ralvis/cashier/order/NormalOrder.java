 /**
 * @author elvis.zhang
 * Description: 
 * 没有任何优惠的定单
 * 2016年3月11日下午1:28:35
 */
package com.ralvis.cashier.order;

import com.ralvis.cashier.print.printer.KeyMoneyWithUomPrinter;
import com.ralvis.cashier.utils.Settings;

public class NormalOrder extends Order {
	@Override
	public void buildDiscountPrinter() {
		linePrinters.add(new KeyMoneyWithUomPrinter(Settings.getItemsTotalKey(), 
				totalMoney, 
				Settings.getMoneyDecimal(), 
				Settings.getMoneyUom()));
	}
}

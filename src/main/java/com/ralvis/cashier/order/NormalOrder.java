 /**
 * @author elvis.zhang
 * Description: 
 * 没有任何优惠的定单
 * 2016年3月11日下午1:28:35
 */
package com.ralvis.cashier.order;

import java.util.List;

import com.ralvis.cashier.item.entity.ItemDetail;
import com.ralvis.cashier.print.printer.KeyMoneyWithUomPrinter;
import com.ralvis.cashier.setting.Settings;

public class NormalOrder extends Order {
	public NormalOrder() {
		
	}
	public NormalOrder(List<ItemDetail> itemDetails) {
		super(itemDetails);
	}
	
	@Override
	public void buildDiscountPrinter() {
		linePrinters.add(new KeyMoneyWithUomPrinter(Settings.getItemsTotalKey(), 
				totalMoney, 
				Settings.getMoneyDecimal(), 
				Settings.getMoneyUom()));
	}
}

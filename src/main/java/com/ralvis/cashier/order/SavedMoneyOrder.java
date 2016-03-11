 /**
 * @author elvis.zhang
 * Description: 
 * 省钱的订单
 * 2016年3月11日下午2:52:05
 */
package com.ralvis.cashier.order;

import java.math.BigDecimal;
import com.ralvis.cashier.item.entity.ItemDetail;
import com.ralvis.cashier.print.lineprinter.ItemPurchaseDetailWithSavedMoney;
import com.ralvis.cashier.print.printer.KeyMoneyWithUomPrinter;
import com.ralvis.cashier.utils.Settings;

public class SavedMoneyOrder extends Order{

	@Override
	public void buildDiscountPrinter() {
		super.buildTotalLinePrinter();
		linePrinters.add(new KeyMoneyWithUomPrinter(Settings.getItemSavedKey(),
				getTotalSavedMoney(), 
				Settings.getMoneyDecimal(), 
				Settings.getMoneyUom()));
	}
	
	private BigDecimal getTotalSavedMoney() {
		BigDecimal savedMoney = BigDecimal.ZERO;
		for(ItemDetail itemDetail : items) {
			if (itemDetail instanceof ItemPurchaseDetailWithSavedMoney) {
				ItemPurchaseDetailWithSavedMoney detail = (ItemPurchaseDetailWithSavedMoney)itemDetail;
				BigDecimal newSavedMoney = detail.getSavedMoney();
				savedMoney = savedMoney.add(newSavedMoney);
			}
		}
		return savedMoney;
	}
}

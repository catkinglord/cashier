/**
 * @author elvis.zhang
 * Description: 
 * 打印小票-打印商品明细优惠-例如
 * 名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)，节省2.00(元)
 * 2016年3月6日上午9:47:14
 */
package com.ralvis.cashier.print.lineprinter;

import com.ralvis.cashier.print.printer.Printer;
import com.ralvis.cashier.print.printer.TrimedKeyMoneyWithUomPrinter;

public class ItemDetailWithSavedMoneyLinePrinter extends ItemDetailLinePrinter {

	public ItemDetailWithSavedMoneyLinePrinter(ItemPurchaseDetailWithSavedMoney detail) {
		super(detail);
		
		buildItemDetailSavedMoney(detail);
	}
	
	private void buildItemDetailSavedMoney(ItemPurchaseDetailWithSavedMoney detail) {
		Printer printer = new TrimedKeyMoneyWithUomPrinter(detail.getSavedKey(), 
				detail.getSavedMoney(),
				detail.getMoneyDecimal(),
				detail.getMoneyUom());
		printers.add(printer);
	}
}

 /**
 * @author elvis.zhang
 * Description: 
 * 买M送N的订单
 * 2016年3月11日下午3:36:35
 */
package com.ralvis.cashier.order;

import com.ralvis.cashier.item.entity.ItemDetail;
import com.ralvis.cashier.print.lineprinter.BuyMForNFreeAmountLinePrinter;
import com.ralvis.cashier.print.lineprinter.ItemFreeAmountDetail;
import com.ralvis.cashier.print.printer.TextPrinter;
import com.ralvis.cashier.setting.Settings;

public class BuyMForNFreeOrder extends SavedMoneyOrder {
	@Override
	public void buildDiscountPrinter() {
		linePrinters.add(new TextPrinter(Settings.getBuyMForNKey()));
		for(ItemDetail itemDetail : items) {
			if (itemDetail instanceof ItemFreeAmountDetail) {
				ItemFreeAmountDetail freeAmountDetail = (ItemFreeAmountDetail)itemDetail;
				linePrinters.add(new BuyMForNFreeAmountLinePrinter(freeAmountDetail));
			}
		}
		super.buildDashLinePrinter();
		super.buildDiscountPrinter();
	}
}

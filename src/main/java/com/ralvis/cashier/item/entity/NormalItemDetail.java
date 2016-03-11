 /**
 * @author elvis.zhang
 * Description: 
 * 无优惠的商品明细
 * 2016年3月11日下午3:53:23
 */
package com.ralvis.cashier.item.entity;

import com.ralvis.cashier.print.lineprinter.ItemDetailLinePrinter;
import com.ralvis.cashier.print.lineprinter.LinePrinter;

public class NormalItemDetail extends ItemDetail{

	public NormalItemDetail(Item item, int amount) {
		super(item, amount);
	}
	
	@Override
	public LinePrinter generateLinePrinter() {
		return new ItemDetailLinePrinter(this);
	}
}

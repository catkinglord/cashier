 /**
 * @author elvis.zhang
 * Description: 
 * 打印总计行
 * 2016年3月11日上午11:54:58
 */
package com.ralvis.cashier.print.lineprinter;

import com.ralvis.cashier.print.printer.KeyMoneyWithUomPrinter;
import com.ralvis.cashier.print.printer.Printer;

public class ItemTotalLinePrinter implements LinePrinter{
	private ItemTotal detail;
	private Printer printer;
	
	public ItemTotalLinePrinter(ItemTotal detail) {
		this.detail = detail;
		if(detail == null) {
			throw new RuntimeException("detail不能为空");
		}
		buildPrinters();
	} 
	private void buildPrinters() {
		printer = new KeyMoneyWithUomPrinter(detail.getItemTotalKey(), 
				detail.getItemTotalMoney(), 
				detail.getMoneyDecimal(),
				detail.getMoneyUom());
	}

	@Override
	public String print() {
		return printer.print();
	}
}

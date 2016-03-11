 /**
 * @author elvis.zhang
 * Description: 
 * 打印买M送N优惠情况的行
 * 2016年3月11日上午10:48:45
 */
package com.ralvis.cashier.print.lineprinter;

import com.ralvis.cashier.print.printer.KeyAmountWithUomPrinter;
import com.ralvis.cashier.print.printer.KeyValuePrinter;
import com.ralvis.cashier.print.printer.Printer;

public class BuyMForNFreeAmountLinePrinter implements LinePrinter{
	private ItemFreeAmountDetail detail;
	private Printer itemNamePrinter;
	private Printer freeAmountPrinter;
	
	public BuyMForNFreeAmountLinePrinter(ItemFreeAmountDetail detail) {
		this.detail = detail;
		if(detail == null) {
			throw new RuntimeException("detail不能为空");
		}
		buildPrinters();
	}
	private void buildPrinters() {
		buildNamePrinter();
		buildAmountPrinter();
	}
	private void buildAmountPrinter() {
		itemNamePrinter = new KeyValuePrinter(detail.getNameKey(), 
				detail.getNameValue());
	}
	private void buildNamePrinter() {
		freeAmountPrinter = new KeyAmountWithUomPrinter(detail.getAmountKey(), 
				detail.getFreeAmount(),
				detail.getAmountUom());
	}
	
	@Override
	public String print() {
		String itemName = itemNamePrinter.print();
		String freeAmount = freeAmountPrinter.print();
		return String.format("%s，%s", itemName, freeAmount);
	}
}

/**
 * @author elvis.zhang
 * Description: 
 * 打印小票-打印商品明细-例如
 * 名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)
 * 2016年3月5日下午6:24:38
 */
package com.ralvis.cashier.print.lineprinter;

import java.util.ArrayList;
import java.util.List;

import com.ralvis.cashier.print.printer.KeyAmountWithUomPrinter;
import com.ralvis.cashier.print.printer.KeyMoneyWithUomPrinter;
import com.ralvis.cashier.print.printer.KeyValuePrinter;
import com.ralvis.cashier.print.printer.Printer;
import com.ralvis.cashier.print.printer.TrimedKeyMoneyWithUomPrinter;

public class ItemDetailLinePrinter implements LinePrinter{
	protected List<Printer> printers = new ArrayList<>();
	private ItemPurchaseDetail detail;
	
	public ItemDetailLinePrinter(ItemPurchaseDetail detail) {
		this.detail = detail;
		if(detail == null) {
			throw new RuntimeException("detail不能为空");
		}
		buildPrinters();
	}
	private void buildPrinters() {
		buildItemDetailName();
		buildItemDetailAmount();
		buildItemDetailUnitPrice();
		buildItemDetailTotal();
	}
	private void buildItemDetailName() {
		Printer printer = new KeyValuePrinter(detail.getNameKey(), 
				detail.getNameValue());
		printers.add(printer);		
	}
	private void buildItemDetailAmount() {
		Printer printer = new KeyAmountWithUomPrinter(detail.getAmountKey(), 
				detail.getAmount(),
				detail.getAmountUom());
		printers.add(printer);
	}
	private void buildItemDetailUnitPrice() {
		Printer printer = new KeyMoneyWithUomPrinter(detail.getUnitPriceKey(), 
				detail.getUnitPriceMoney(),
				detail.getMoneyDecimal(),
				detail.getMoneyUom());
		printers.add(printer);
	}
	private void buildItemDetailTotal() {
		Printer printer = new KeyMoneyWithUomPrinter(detail.getTotalKey(), 
				detail.getTotalMoeny(),
				detail.getMoneyDecimal(),
				detail.getMoneyUom());
		printers.add(printer);
	}
	
	@Override
	public String print() {
		StringBuffer buffer = new StringBuffer();
		for(Printer printer : printers) {
			buffer.append(printer.print());
			buffer.append("，");
		}
		buffer.setLength(buffer.length()-1);
		return buffer.toString();
	}

}

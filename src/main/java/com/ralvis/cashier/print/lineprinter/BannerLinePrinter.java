 /**
 * @author elvis.zhang
 * Description: 
 * 打印小票-打印头-例如***<没钱赚商店>购物清单***
 * 2016年3月8日下午1:30:25
 */
package com.ralvis.cashier.print.lineprinter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ralvis.cashier.print.printer.AngleBracketsPrinter;
import com.ralvis.cashier.print.printer.Printer;
import com.ralvis.cashier.print.printer.TextPrinter;

public class BannerLinePrinter implements LinePrinter{

	private static final String DEFAULT_STORE_NAME = "没钱赚商店";
	private static final String DEFAULT_PRINT_NAME = "购物清单";
	
	private String storeName;
	private List<Printer> printers;
	
	public BannerLinePrinter(String storeName) {
		if (StringUtils.isEmpty(storeName)) {
			storeName = DEFAULT_STORE_NAME;
		}
		this.storeName = storeName;
		printers = new ArrayList<>();
		buildPrinters();
	}
	void buildPrinters() {
		buildStars();
		buildStore();
		buildItemList();
		buildStars();
	}
	void buildStars() {
		Printer threeStars = new RepeatSymbolLinePrinter(3, '*');
		printers.add(threeStars);
	}
	void buildStore() {
		Printer store = new AngleBracketsPrinter(storeName);
		printers.add(store);
	}
	void buildItemList() {
		Printer store = new TextPrinter(DEFAULT_PRINT_NAME);
		printers.add(store);
	}
	
	@Override
	public String print() {
		StringBuffer buffer = new StringBuffer();
		for(Printer printer : printers) {
			buffer.append(printer.print());
		}
		return buffer.toString();
	}
}

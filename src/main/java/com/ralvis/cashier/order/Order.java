 /**
 * @author elvis.zhang
 * Description: 
 * 购买清单抽象类
 * 2016年3月11日下午1:17:32
 */
package com.ralvis.cashier.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ralvis.cashier.item.entity.ItemDetail;
import com.ralvis.cashier.print.lineprinter.BannerLinePrinter;
import com.ralvis.cashier.print.lineprinter.RepeatSymbolLinePrinter;
import com.ralvis.cashier.print.printer.KeyMoneyWithUomPrinter;
import com.ralvis.cashier.print.printer.Printer;
import com.ralvis.cashier.setting.Settings;

public abstract class Order {
	protected List<ItemDetail> items;
	protected BigDecimal totalMoney;
	protected List<Printer> linePrinters;
	protected List<String> purchasingList;
	
	public Order() {
		items = new ArrayList<>();
		totalMoney = BigDecimal.ZERO;
		linePrinters = new ArrayList<>();
		purchasingList = new ArrayList<>();
	}
	
	public void addItemDetail(ItemDetail detail) {
		items.add(detail);
		totalMoney = totalMoney.add(detail.getTotalMoney());
	}
	
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	
	//构造打印清单-行打印
	protected void buildLinePrinters() {
		buildBannerPrinter();
		buildItemsPrinter();
		buildDashLinePrinter();
		buildDiscountPrinter();
		buildBottomLinePrinter();
	}
	//构造打印清单-首行
	protected void buildBannerPrinter() {
		linePrinters.add(new BannerLinePrinter(Settings.getStoreName()));
	}
	protected void buildItemsPrinter() {
		for(ItemDetail itemDetail : items) {
			linePrinters.add(itemDetail.generateLinePrinter());
		}
	}
	protected void buildDashLinePrinter() {
		linePrinters.add(new RepeatSymbolLinePrinter(Settings.getDashNumber(),
				'-'));
	}
	
	//打印清单-优惠情况
	public abstract void buildDiscountPrinter();
	
	protected void buildBottomLinePrinter() {
		linePrinters.add(new RepeatSymbolLinePrinter(Settings.getDashNumber(),
				'*'));
	}
	protected void buildTotalLinePrinter() {
		linePrinters.add(new KeyMoneyWithUomPrinter(Settings.getItemsTotalKey(),
				totalMoney, 
				Settings.getMoneyDecimal(), 
				Settings.getMoneyUom()));
	}
	
	//构造打印清单
	public void buildPurchasingList() {
		buildLinePrinters();
		for(Printer printer : linePrinters) {
			purchasingList.add(printer.print());
		}
	}
	
	//返回打印清单
	public List<String> getPurchasingList() {
		return purchasingList;
	}
}

/**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印一行购买商品明细
 * 名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)，节省2.00(元)
 * 2016年3月6日上午9:30:54
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.print.lineprinter.LinePrinter;

public class ItemDetailWithSavedMoneyLinePrinterTest extends BaseTestNG{
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintDetailNull() {
		LinePrinter printer = new ItemDetailWithSavedMoneyLinePrinter(null);
		Assert.assertNull(printer);
	}
	
	@Test
	public void testCustomPrint() {
		ItemPurchaseDetailWithSavedMoney detail = new MockItemPurchaseDetail();
		LinePrinter printer = new ItemDetailWithSavedMoneyLinePrinter(detail);
		String line = printer.print();
		Assert.assertEquals(line, "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)，节省2.00(元)");
	}
	
	private static class MockItemPurchaseDetail implements ItemPurchaseDetailWithSavedMoney {
		@Override
		public String getNameKey() {
			return "名称";
		}
		@Override
		public String getNameValue() {
			return "可口可乐";
		}
		@Override
		public String getAmountKey() {
			return "数量";
		}
		@Override
		public int getAmount() {
			return 3;
		}
		@Override
		public String getAmountUom() {
			return "瓶";
		}
		@Override
		public String getUnitPriceKey() {
			return "单价";
		}
		@Override
		public BigDecimal getUnitPriceMoney() {
			return new BigDecimal("3");
		}
		@Override
		public String getMoneyUom() {
			return "元";
		}
		@Override
		public String getTotalKey() {
			return "小计";
		}
		@Override
		public BigDecimal getTotalMoney() {
			return new BigDecimal("9");
		}
		@Override
		public String getSavedKey() {
			return "节省";
		}
		@Override
		public BigDecimal getSavedMoney() {
			return new BigDecimal("2");
		}
		@Override
		public int getMoneyDecimal() {
			return 2;
		}
	}
	
}

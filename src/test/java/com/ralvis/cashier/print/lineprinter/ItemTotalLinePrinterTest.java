 /**
 * @author elvis.zhang
 * Description: 
 * 测试打印总计金额
 * 2016年3月11日上午11:53:30
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.print.printer.Printer;
import com.ralvis.cashier.utils.Settings;

public class ItemTotalLinePrinterTest {
	private static class MockItemTotal implements ItemTotal {
		@Override
		public String getItemTotalKey() {
			return Settings.getItemsTotalKey();
		}

		@Override
		public BigDecimal getItemTotalMoney() {
			return new BigDecimal("20.05");
		}

		@Override
		public String getMoneyUom() {
			return Settings.getMoneyUom();
		}

		@Override
		public int getMoneyDecimal() {
			return Settings.getMoneyDecimal();
		}
	}
	
	@Test
	public void testPrint() {
		ItemTotal itemTotal = new MockItemTotal();
		Printer printer = new ItemTotalLinePrinter(itemTotal);
		String line = printer.print();
		Assert.assertEquals(line, "总计：20.05(元)");
	}
}

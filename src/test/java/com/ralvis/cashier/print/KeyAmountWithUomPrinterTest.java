/**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印数量-例如数量: 2个
 * 2016年3月5日下午5:03:54
 */
package com.ralvis.cashier.print;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.print.service.Printer;
import com.ralvis.cashier.print.service.impl.KeyAmountWithUomPrinter;

public class KeyAmountWithUomPrinterTest extends BaseTestNG{
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyNull() {
		Printer printer = new KeyAmountWithUomPrinter(null, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyEmpty() {
		Printer printer = new KeyAmountWithUomPrinter("", 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintAmountNegative() {
		Printer printer = new KeyAmountWithUomPrinter("", -1, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintAmountZero() {
		Printer printer = new KeyAmountWithUomPrinter("", 0, "");
		Assert.assertNull(printer);
	}
	
	@Test
	public void testCustomPrint() {
		Printer printer = new KeyAmountWithUomPrinter("数量", 2, "个");
		String line = printer.print();
		Assert.assertEquals(line, "数量: 2个");
	}
	
	@Test
	public void testPrintUomNull() {
		Printer printer = new KeyAmountWithUomPrinter("数量", 2, null);
		String line = printer.print();
		Assert.assertEquals(line, "数量: 2");
	}
	
	@Test
	public void testPrintUomEmpty() {
		Printer printer = new KeyAmountWithUomPrinter("数量", 2, "");
		String line = printer.print();
		Assert.assertEquals(line, "数量: 2");
	}
}

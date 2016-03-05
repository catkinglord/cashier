/**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印名称-例如名称: 苹果
 * 2016年3月5日下午4:00:54
 */
package com.ralvis.cashier.print.printer;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.print.printer.KeyValuePrinter;
import com.ralvis.cashier.print.printer.Printer;

public class KeyValuePrinterTest extends BaseTestNG{
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyNull() {
		Printer printer = new KeyValuePrinter(null, null);
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyEmpty() {
		Printer printer = new KeyValuePrinter("", null);
		Assert.assertNull(printer);
	}
	
	@Test
	public void testPrintValueNull() {
		Printer printer = new KeyValuePrinter("名称", null);
		String line = printer.print();
		Assert.assertEquals(line, "名称: 未知");
	}
	
	@Test
	public void testPrintValueEmpty() {
		Printer printer = new KeyValuePrinter("名称", "");
		String line = printer.print();
		Assert.assertEquals(line, "名称: 未知");
	}
	
	@Test
	public void testCustomPrint() {
		Printer printer = new KeyValuePrinter("名称", "苹果");
		String line = printer.print();
		Assert.assertEquals(line, "名称: 苹果");
	}
}

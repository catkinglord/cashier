 /**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印文字-例如购物清单
 * 2016年3月8日下午1:22:06
 */
package com.ralvis.cashier.print.printer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ralvis.cashier.base.BaseTestNG;

public class TextPrinterTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintTextNull() {
		Printer printer = new TextPrinter(null);
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintTextEmpty() {
		Printer printer = new TextPrinter("");
		Assert.assertNull(printer);
	}
	
	@Test
	public void testCustomPrintText() {
		Printer printer = new TextPrinter("购物清单");
		String line = printer.print();
		Assert.assertEquals(line, "购物清单");
	}
}

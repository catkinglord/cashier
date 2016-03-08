 /**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印一行文字以冒号结尾
 * 2016年3月8日上午11:45:01
 */
package com.ralvis.cashier.print.lineprinter;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ralvis.cashier.base.BaseTestNG;

public class TitleLinePrinterTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintTitleNull() {
		LinePrinter printer = new TitleLinePrinter(null);
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintTitleEmpty() {
		LinePrinter printer = new TitleLinePrinter("");
		Assert.assertNull(printer);
	}
	
	@Test
	public void testPrintCustomTitle() {
		LinePrinter printer = new TitleLinePrinter("买二赠一商品");
		String line = printer.print();
		Assert.assertEquals(line, "买二赠一商品：");
	}
}

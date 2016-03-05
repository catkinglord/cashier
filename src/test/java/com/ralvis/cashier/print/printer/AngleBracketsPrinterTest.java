/**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印尖括号名称
 * 2016年3月5日下午3:36:03
 */
package com.ralvis.cashier.print.printer;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.print.printer.AngleBracketsPrinter;
import com.ralvis.cashier.print.printer.Printer;

public class AngleBracketsPrinterTest extends BaseTestNG{
	@Test
	public void testPrintNull() {
		Printer printer = new AngleBracketsPrinter(null);
		String line = printer.print();
		Assert.assertEquals(line, "");
	}
	
	@Test
	public void testPrintEmpty() {
		Printer printer = new AngleBracketsPrinter("");
		String line = printer.print();
		Assert.assertEquals(line, "");
	}
	
	@Test
	public void testPrintWithName() {
		Printer printer = new AngleBracketsPrinter("没钱赚商店");
		String line = printer.print();
		Assert.assertEquals(line, "<没钱赚商店>");
	}
}

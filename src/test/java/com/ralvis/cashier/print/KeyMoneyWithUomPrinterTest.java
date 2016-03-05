/**
 * @author elvis.zhang
 * Description:
 * 测试小票打印-打印金额-例如单价: 2.00(元) 
 * 2016年3月5日下午5:15:45
 */
package com.ralvis.cashier.print;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.print.service.Printer;
import com.ralvis.cashier.print.service.impl.KeyMoneyWithUomPrinter;

public class KeyMoneyWithUomPrinterTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyNull() {
		Printer printer = new KeyMoneyWithUomPrinter(null, BigDecimal.ZERO, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyEmpty() {
		Printer printer = new KeyMoneyWithUomPrinter("", BigDecimal.ZERO, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintMoneyNull() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", null, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintMoneyNegative() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", BigDecimal.ONE.negate(), 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintMoneyZero() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", BigDecimal.ZERO, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintDecimalNegative() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", BigDecimal.ONE, -1, "");
		Assert.assertNull(printer);
	}
	
	@Test
	public void testPrintDecimalZero() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", BigDecimal.ONE, 0, "元");
		String line = printer.print();
		Assert.assertEquals(line, "单价: 1(元)");
	}
	
	@Test
	public void testPrintDecimalPositive1() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", new BigDecimal("1.2345"), 1, "元");
		String line = printer.print();
		Assert.assertEquals(line, "单价: 1.2(元)");
	}
	
	@Test
	public void testPrintDecimalPositive2() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", new BigDecimal("1.2345"), 2, "元");
		String line = printer.print();
		Assert.assertEquals(line, "单价: 1.23(元)");
	}
	
	@Test
	public void testPrintUomNull() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", new BigDecimal("0.2345"), 2, null);
		String line = printer.print();
		Assert.assertEquals(line, "单价: 0.23(元)");
	}
	
	@Test
	public void testPrintUomEmpty() {
		Printer printer = new KeyMoneyWithUomPrinter("单价", new BigDecimal("0.2345"), 2, "");
		String line = printer.print();
		Assert.assertEquals(line, "单价: 0.23(元)");
	}
}

/**
 * @author elvis.zhang
 * Description:
 * 测试小票打印-打印节省金额-例如节省2.00(元) 
 * 2016年3月5日下午5:57:45
 */
package com.ralvis.cashier.print;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.print.service.Printer;
import com.ralvis.cashier.print.service.impl.TrimedKeyMoneyWithUomPrinter;

public class TrimedKeyMoneyWithUomPrinterTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyNull() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter(null, BigDecimal.ZERO, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintKeyEmpty() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("", BigDecimal.ZERO, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintMoneyNull() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", null, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintMoneyNegative() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", BigDecimal.ONE.negate(), 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintMoneyZero() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", BigDecimal.ZERO, 2, "");
		Assert.assertNull(printer);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testPrintDecimalNegative() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", BigDecimal.ONE, -1, "");
		Assert.assertNull(printer);
	}
	
	@Test
	public void testPrintDecimalZeroMoneyGT1() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", new BigDecimal("1.024"), 0, "元");
		String line = printer.print();
		Assert.assertEquals(line, "节省1(元)");
	}
	
	@Test
	public void testPrintDecimalZeroMoneyEQ1() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", BigDecimal.ONE, 0, "元");
		String line = printer.print();
		Assert.assertEquals(line, "节省1(元)");
	}
	
	@Test
	public void testPrintDecimalZeroMoneyLT1() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", new BigDecimal("0.024"), 0, "元");
		String line = printer.print();
		Assert.assertEquals(line, "节省0(元)");
	}
	
	@Test
	public void testPrintDecimalPositive1() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", new BigDecimal("1.2345"), 1, "元");
		String line = printer.print();
		Assert.assertEquals(line, "节省1.2(元)");
	}
	
	@Test
	public void testPrintDecimalPositive2() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", new BigDecimal("1.2345"), 2, "元");
		String line = printer.print();
		Assert.assertEquals(line, "节省1.23(元)");
	}
	
	@Test
	public void testPrintUomNull() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", new BigDecimal("0.2345"), 2, null);
		String line = printer.print();
		Assert.assertEquals(line, "节省0.23(元)");
	}
	
	@Test
	public void testPrintUomEmpty() {
		Printer printer = new TrimedKeyMoneyWithUomPrinter("节省", new BigDecimal("0.2345"), 2, "");
		String line = printer.print();
		Assert.assertEquals(line, "节省0.23(元)");
	}
}

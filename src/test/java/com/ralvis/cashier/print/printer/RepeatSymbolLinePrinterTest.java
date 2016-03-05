/**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印一行重复字符
 * 2016年3月5日下午1:14:54
 */
package com.ralvis.cashier.print.printer;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.print.lineprinter.LinePrinter;
import com.ralvis.cashier.print.lineprinter.RepeatSymbolLinePrinter;

public class RepeatSymbolLinePrinterTest extends BaseTestNG{
	@Test
	public void testDefaultGenerateLine() {
		LinePrinter printer = new RepeatSymbolLinePrinter();
		String line = printer.print();
		Assert.assertEquals(line, "----------------------");
	}
	
	@Test
	public void testCustomerGenerateLineNegative() {
		LinePrinter printer = new RepeatSymbolLinePrinter(-1, '*');
		String line = printer.print();
		Assert.assertEquals(line, "");
	}
	
	@Test
	public void testCustomerGenerateLineZero() {
		LinePrinter printer = new RepeatSymbolLinePrinter(0, '*');
		String line = printer.print();
		Assert.assertEquals(line, "");
	}
	
	@Test
	public void testCustomerGenerateLinePositiveStar() {
		LinePrinter printer = new RepeatSymbolLinePrinter(3, '*');
		String line = printer.print();
		Assert.assertEquals(line, "***");
	}
	
	@Test
	public void testCustomerGenerateLinePositiveDash() {
		LinePrinter printer = new RepeatSymbolLinePrinter(4, '-');
		String line = printer.print();
		Assert.assertEquals(line, "----");
	}
}

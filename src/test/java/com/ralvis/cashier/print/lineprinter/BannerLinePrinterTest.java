 /**
 * @author elvis.zhang
 * Description: 
 * 测试小票打印-打印小票头 例如***<没钱赚商店>购物清单***
 * 2016年3月8日下午1:38:33
 */
package com.ralvis.cashier.print.lineprinter;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;

public class BannerLinePrinterTest extends BaseTestNG{

	@Test
	public void testPrintStoreNameNull() {
		LinePrinter printer = new BannerLinePrinter(null);
		String line = printer.print();
		Assert.assertEquals(line, "***<没钱赚商店>购物清单***");
	}
	
	@Test
	public void testPrintCustomStoreName() {
		LinePrinter printer = new BannerLinePrinter("好德便利店");
		String line = printer.print();
		Assert.assertEquals(line, "***<好德便利店>购物清单***");
	}
}

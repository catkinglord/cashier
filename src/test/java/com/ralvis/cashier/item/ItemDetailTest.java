 /**
 * @author elvis.zhang
 * Description: 
 * 测试购买的商品明细-
 * 2016年3月9日下午2:10:44
 */
package com.ralvis.cashier.item;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.discount.BuyMForNFreeDiscount;
import com.ralvis.cashier.discount.NormalDiscount;
import com.ralvis.cashier.item.entity.Item;
import com.ralvis.cashier.item.entity.ItemDetail;
import com.ralvis.cashier.item.entity.NormalDiscountItemDetail;
import com.ralvis.cashier.print.lineprinter.ItemDetailLinePrinter;
import com.ralvis.cashier.print.lineprinter.ItemDetailWithSavedMoneyLinePrinter;
import com.ralvis.cashier.print.lineprinter.LinePrinter;

public class ItemDetailTest extends BaseTestNG {

	@Test(expectedExceptions={RuntimeException.class})
	public void testDiscountNull() {
		Item item = new Item("ITEM000001", "可口可乐", "瓶", new BigDecimal("3.00"));
		ItemDetail detail = new ItemDetail(item, 1, null);
		Assert.assertNull(detail);
	}
	
	@Test
	public void testDiscountOriginal() {
		Item item = new Item("ITEM000001", "可口可乐", "瓶", new BigDecimal("3.00"));
		ItemDetail detail = new ItemDetail(item, 3);
		LinePrinter printer = new ItemDetailLinePrinter(detail);
		String line = printer.print();
		Assert.assertEquals(line, "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)");
	}
	
	@Test
	public void testDiscountNormal() {
		Item item = new Item("ITEM000001", "可口可乐", "瓶", new BigDecimal("3.00"));
		NormalDiscountItemDetail detail = new NormalDiscountItemDetail(item, 3, new NormalDiscount(95));
		LinePrinter printer = new ItemDetailWithSavedMoneyLinePrinter(detail);
		String line = printer.print();
		Assert.assertEquals(line, "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：8.55(元)，节省0.45(元)");
	}
	
	@Test
	public void testDiscountMForN() {
		Item item = new Item("ITEM000001", "可口可乐", "瓶", new BigDecimal("3.00"));
		ItemDetail detail = new ItemDetail(item, 3, new BuyMForNFreeDiscount(2, 1));
		LinePrinter printer = new ItemDetailLinePrinter(detail);
		String line = printer.print();
		Assert.assertEquals(line, "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)");
	}
}

 /**
 * @author elvis.zhang
 * Description: 
 * 测试打印买m赠n的数量统计
 * 2016年3月11日上午10:53:30
 */
package com.ralvis.cashier.print.lineprinter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ralvis.cashier.discount.BuyMForNFreeDiscount;
import com.ralvis.cashier.item.entity.BuyMForNFreeItemDetail;
import com.ralvis.cashier.item.entity.Item;
import com.ralvis.cashier.item.service.ItemService;
import com.ralvis.cashier.item.service.MockItemService;

public class BuyMForNFreeAmoutLinePrinterTest {

	@Test
	public void testPrint() {
		ItemService itemService = new MockItemService();
		Item item = itemService.findByItemCode("ITEM000001");
		BuyMForNFreeItemDetail detail = new BuyMForNFreeItemDetail(item, 3, new BuyMForNFreeDiscount(2, 1));
		BuyMForNFreeAmountLinePrinter printer = new BuyMForNFreeAmountLinePrinter(detail);
		String line = printer.print();
		Assert.assertEquals(line, "名称：可口可乐，数量：1瓶");
	}
}

 /**
 * @author elvis.zhang
 * Description: 
 * 测试商品服务
 * 2016年3月8日下午6:15:25
 */
package com.ralvis.cashier.item;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.item.entity.Item;
import com.ralvis.cashier.item.service.ItemService;
import com.ralvis.cashier.item.service.MockItemService;

public class MockItemServiceTest extends BaseTestNG{
	@Test(expectedExceptions={RuntimeException.class})
	public void testMockItemServiceFindByItemCodeNotFound() {
		ItemService itemService = MockItemService.getInstance();
		Item item = itemService.findByItemCode("hello");
		Assert.assertNull(item);
	}
	
	@Test
	public void testMockItemServiceFindByItemCodeFound() {
		ItemService itemService = MockItemService.getInstance();
		Item item = itemService.findByItemCode("ITEM000001");
		Assert.assertEquals(item.getItemName(), "可口可乐");
	}
}

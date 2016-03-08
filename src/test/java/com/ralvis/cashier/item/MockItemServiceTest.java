 /**
 * @author elvis.zhang
 * Description: 
 * 测试商品服务
 * 2016年3月8日下午6:15:25
 */
package com.ralvis.cashier.item;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.item.entity.Item;
import com.ralvis.cashier.item.service.ItemService;
import com.ralvis.cashier.item.service.MockItemService;

public class MockItemServiceTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testMockItemServiceFindByItemCodeNotFound() {
		ItemService itemService = new MockItemService();
		Map<String, Item> map = new HashMap<>();
		map.put("ITEM000001", new Item("ITEM000001", "可口可乐", "瓶", "元"));
		map.put("ITEM000002", new Item("ITEM000002", "羽毛球", "个", "元"));
		map.put("ITEM000003", new Item("ITEM000003", "苹果", "斤", "元"));
		MockItemService.initMap(map);
		
		Item item = itemService.findByItemCode("hello");
		Assert.assertNull(item);
	}
	
	@Test
	public void testMockItemServiceFindByItemCodeFound() {
		ItemService itemService = new MockItemService();
		Map<String, Item> map = new HashMap<>();
		map.put("ITEM000001", new Item("ITEM000001", "可口可乐", "瓶", "元"));
		map.put("ITEM000002", new Item("ITEM000002", "羽毛球", "个", "元"));
		map.put("ITEM000003", new Item("ITEM000003", "苹果", "斤", "元"));
		MockItemService.initMap(map);
		
		Item item = itemService.findByItemCode("ITEM000001");
		Assert.assertEquals(item.getItemName(), "可口可乐");
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testMockItemServiceNull() {
		ItemService itemService = new MockItemService();
		MockItemService.initMap(null);
		Item item = itemService.findByItemCode("hello");
		Assert.assertNotNull(item);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testMockItemServiceEmpty() {
		ItemService itemService = new MockItemService();
		MockItemService.initMap(new HashMap<String, Item>());
		Item item = itemService.findByItemCode("hello");
		Assert.assertNotNull(item);
	}
}

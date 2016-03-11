 /**
 * @author elvis.zhang
 * Description: 
 * 商品类的模拟服务实现类
 * 2016年3月8日下午6:06:43
 */
package com.ralvis.cashier.item.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.ralvis.cashier.item.entity.Item;

public class MockItemService implements ItemService{
	private static Map<String, Item> map = new HashMap<>();
	static {
		map.put("ITEM000001", new Item("ITEM000001", "可口可乐", "瓶", new BigDecimal("3.00")));
		map.put("ITEM000002", new Item("ITEM000002", "羽毛球", "个", new BigDecimal("1.00")));
		map.put("ITEM000003", new Item("ITEM000003", "苹果", "斤", new BigDecimal("5.50")));
	}
	
	public static void initMap( Map<String, Item> aMap) {
		map = aMap;
	}
	
	@Override
	public Item findByItemCode(String itemCode) {
		if (map == null || map.isEmpty()) {
			throw new RuntimeException("系统没有正确初始化，没有商品数据");
		}
		if (!map.containsKey(itemCode)) {
			throw new RuntimeException(String.format("系统没有指定的商品%s", itemCode));
		}
		return map.get(itemCode);
	}
}

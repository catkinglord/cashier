 /**
 * @author elvis.zhang
 * Description: 
 * 测试正常订单
 * 2016年3月11日下午2:32:04
 */
package com.ralvis.cashier.order;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ralvis.cashier.item.entity.Item;
import com.ralvis.cashier.item.entity.ItemDetail;
import com.ralvis.cashier.item.entity.NormalItemDetail;
import com.ralvis.cashier.item.service.ItemService;
import com.ralvis.cashier.item.service.MockItemService;

public class NormalOrderTest {

	@Test
	public void testPrintEmpty() {
		Order order = new NormalOrder();
		
		order.buildPurchasingList();
		
		List<String> lines = order.getPurchasingList();
		List<String> expectedLines = new ArrayList<>();
		expectedLines.add("***<没钱赚商店>购物清单***");
		expectedLines.add("----------------------");
		expectedLines.add("总计：0.00(元)");
		expectedLines.add("**********************");
		
		Assert.assertEquals(lines, expectedLines);
	}
	@Test
	public void testPrintOneItem() {
		Order order = new NormalOrder();
		
		ItemService itemService = new MockItemService();
		Item coco = itemService.findByItemCode("ITEM000001");
		ItemDetail cocoDetail = new NormalItemDetail(coco, 3);
		order.addItemDetail(cocoDetail);
		
		order.buildPurchasingList();
		
		List<String> lines = order.getPurchasingList();
		List<String> expectedLines = new ArrayList<>();
		expectedLines.add("***<没钱赚商店>购物清单***");
		expectedLines.add("名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)");
		expectedLines.add("----------------------");
		expectedLines.add("总计：9.00(元)");
		expectedLines.add("**********************");
		
		Assert.assertEquals(lines, expectedLines);
	}
	
	@Test
	public void testPrintThreeItems() {
		Order order = new NormalOrder();
		
		ItemService itemService = new MockItemService();
		Item coco = itemService.findByItemCode("ITEM000001");
		ItemDetail cocoDetail = new NormalItemDetail(coco, 3);
		order.addItemDetail(cocoDetail);
		
		Item ball = itemService.findByItemCode("ITEM000002");
		ItemDetail ballDetail = new NormalItemDetail(ball, 5);
		order.addItemDetail(ballDetail);
		
		Item apple = itemService.findByItemCode("ITEM000003");
		ItemDetail appleDetail = new NormalItemDetail(apple, 2);
		order.addItemDetail(appleDetail);
		
		order.buildPurchasingList();
		
		List<String> lines = order.getPurchasingList();
		List<String> expectedLines = new ArrayList<>();
		expectedLines.add("***<没钱赚商店>购物清单***");
		expectedLines.add("名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)");
		expectedLines.add("名称：羽毛球，数量：5个，单价：1.00(元)，小计：5.00(元)");
		expectedLines.add("名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)");
		expectedLines.add("----------------------");
		expectedLines.add("总计：25.00(元)");
		expectedLines.add("**********************");
		
		Assert.assertEquals(lines, expectedLines);
	}
}

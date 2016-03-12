/**
 * @author elvis.zhang
 * Description: 
 * 测试输入解析获取订单类
 * 2016年3月12日下午12:47:15
 */
package com.ralvis.cashier.input;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;
import com.ralvis.cashier.order.BuyMForNFreeOrder;
import com.ralvis.cashier.order.NormalOrder;
import com.ralvis.cashier.order.Order;
import com.ralvis.cashier.order.SavedMoneyOrder;
import com.ralvis.cashier.setting.DiscountFacotory;
import com.ralvis.cashier.setting.ItemDiscountRecordService;
import com.ralvis.cashier.setting.MockItemDiscountRecordService;

public class InputParserTest extends BaseTestNG {

	@Test
	public void testNormalInput() {
		ItemDiscountRecordService recordService = MockItemDiscountRecordService.getInstance();
		recordService.reset();
		String orderJson = "['ITEM000001', 'ITEM000001', "
						+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
						+ "'ITEM000003-2', "
						+ "'ITEM000005', 'ITEM000005', 'ITEM000005']";
		Input input = new InputParser();
		Order order = input.getOrder(orderJson);
		Assert.assertEquals(order.getClass(), NormalOrder.class);
	}
	
	@Test
	public void testSavedMoneyInput() {
		ItemDiscountRecordService recordService = MockItemDiscountRecordService.getInstance();
		recordService.reset();
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.NORMAL_DISCOUNT);
		String orderJson = "['ITEM000001', 'ITEM000001', "
						+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
						+ "'ITEM000003-2', "
						+ "'ITEM000005', 'ITEM000005', 'ITEM000005']";
		Input input = new InputParser();
		Order order = input.getOrder(orderJson);
		Assert.assertEquals(order.getClass(), SavedMoneyOrder.class);
	}
	
	@Test
	public void testMForNFreeInput() {
		ItemDiscountRecordService recordService = MockItemDiscountRecordService.getInstance();
		recordService.reset();
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.MFORNFREE_DISCOUNT);
		String orderJson = "['ITEM000001', 'ITEM000001', "
						+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
						+ "'ITEM000003-2', "
						+ "'ITEM000005', 'ITEM000005', 'ITEM000005']";
		Input input = new InputParser();
		Order order = input.getOrder(orderJson);
		Assert.assertEquals(order.getClass(), BuyMForNFreeOrder.class);
	}
	
	@Test
	public void testMForNFreeInputAndDiscount95() {
		ItemDiscountRecordService recordService = MockItemDiscountRecordService.getInstance();
		recordService.reset();
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.MFORNFREE_DISCOUNT);
		recordService.setItemDiscount("ITEM000003", DiscountFacotory.NORMAL_DISCOUNT);
		String orderJson = "['ITEM000001', 'ITEM000001', "
						+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
						+ "'ITEM000003-2', "
						+ "'ITEM000005', 'ITEM000005', 'ITEM000005']";
		Input input = new InputParser();
		Order order = input.getOrder(orderJson);
		Assert.assertEquals(order.getClass(), BuyMForNFreeOrder.class);
	}
}

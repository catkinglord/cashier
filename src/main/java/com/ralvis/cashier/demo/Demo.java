/**
 * @author elvis.zhang
 * Description: 
 * 收银台展示类
 * 2016年3月12日下午2:47:29
 */
package com.ralvis.cashier.demo;

import java.util.List;
import com.ralvis.cashier.input.Input;
import com.ralvis.cashier.input.InputParser;
import com.ralvis.cashier.order.Order;
import com.ralvis.cashier.setting.DiscountFacotory;
import com.ralvis.cashier.setting.ItemDiscountRecordService;
import com.ralvis.cashier.setting.MockItemDiscountRecordService;

public class Demo {
	private static ItemDiscountRecordService recordService = MockItemDiscountRecordService.getInstance();
	
	public static void main(String[] args) {
		
		demoNormalOrder();
		demo95DiscountOrder();
		demoMForNFreeOrder();
		demoMForNFreeAnd95DiscountOrder();
	}
	
	
	private static void demoNormalOrder() {
		recordService.reset();
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.ORIGINAL_DISCOUNT);
		recordService.setItemDiscount("ITEM000002", DiscountFacotory.ORIGINAL_DISCOUNT);
		recordService.setItemDiscount("ITEM000003", DiscountFacotory.ORIGINAL_DISCOUNT);

		String orderJson = "['ITEM000001', 'ITEM000001', "
				+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
				+ "'ITEM000003-2', "
				+ "'ITEM000002', 'ITEM000002', 'ITEM000002']";
		System.out.println("没有优惠的订单如下：");
		printOrder(orderJson);
	}
	private static void demo95DiscountOrder() {
		recordService.reset();
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.ORIGINAL_DISCOUNT);
		recordService.setItemDiscount("ITEM000002", DiscountFacotory.ORIGINAL_DISCOUNT);
		recordService.setItemDiscount("ITEM000003", DiscountFacotory.NORMAL_DISCOUNT);

		String orderJson = "['ITEM000001', 'ITEM000001', "
				+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
				+ "'ITEM000003-2', "
				+ "'ITEM000002', 'ITEM000002', 'ITEM000002']";
		System.out.println("95折优惠的订单如下：");
		printOrder(orderJson);
	}
	private static void demoMForNFreeOrder() {
		recordService.reset();
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.MFORNFREE_DISCOUNT);
		recordService.setItemDiscount("ITEM000002", DiscountFacotory.MFORNFREE_DISCOUNT);
		recordService.setItemDiscount("ITEM000003", DiscountFacotory.ORIGINAL_DISCOUNT);

		String orderJson = "['ITEM000001', 'ITEM000001', "
				+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
				+ "'ITEM000003-2', "
				+ "'ITEM000002', 'ITEM000002', 'ITEM000002']";
		System.out.println("买二送一优惠的订单如下：");
		printOrder(orderJson);
	}
	private static void demoMForNFreeAnd95DiscountOrder() {
		recordService.reset();
		//ITEM000001既是买二送一，又是95折
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.MFORNFREE_DISCOUNT);
		recordService.setItemDiscount("ITEM000001", DiscountFacotory.NORMAL_DISCOUNT);
		
		recordService.setItemDiscount("ITEM000002", DiscountFacotory.NORMAL_DISCOUNT);
		recordService.setItemDiscount("ITEM000003", DiscountFacotory.ORIGINAL_DISCOUNT);

		String orderJson = "['ITEM000001', 'ITEM000001', "
				+ "'ITEM000001', 'ITEM000001', 'ITEM000001', "
				+ "'ITEM000003-2', "
				+ "'ITEM000002', 'ITEM000002', 'ITEM000002']";
		System.out.println("买二送一和95折扣优惠的订单如下：");
		printOrder(orderJson);
	}
	
	private static void printOrder(String orderJson) {
		Input input = new InputParser();
		Order order = input.getOrder(orderJson);
		order.buildPurchasingList();
		List<String> lines = order.getPurchasingList();
		printOrderList(lines);
	}
	private static void printOrderList(List<String> lines) {
		for(String line : lines) {
			System.out.println(line);
		}
	}
}

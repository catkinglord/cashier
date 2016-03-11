 /**
 * @author elvis.zhang
 * Description: 
 * 2016年3月11日下午6:07:37
 */
package com.ralvis.cashier.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.ralvis.cashier.discount.Discount;
import com.ralvis.cashier.item.entity.Item;
import com.ralvis.cashier.item.entity.ItemDetail;
import com.ralvis.cashier.item.entity.NormalDiscountItemDetail;
import com.ralvis.cashier.item.service.ItemService;
import com.ralvis.cashier.item.service.MockItemService;
import com.ralvis.cashier.order.Order;
import com.ralvis.cashier.setting.ItemDiscountRecordService;
import com.ralvis.cashier.setting.MockItemDiscountRecordService;

public class InputParser implements Input {

	private ItemService itemService;
	private ItemDiscountRecordService itemDiscountRecordService;
	
	public InputParser() {
		itemService = new MockItemService();
		itemDiscountRecordService = new MockItemDiscountRecordService();
	}
	
	@Override
	public Order getOrder(String orderJson) {
		List<String> itemList = JSONArray.parseArray(orderJson, String.class);
		return null;
	}
	
	List<ItemDetail> buildItemDetails(List<String> itemList) {
		Map<String, Integer> itemAmountMap = getItemAmountMap(itemList);
		List<ItemDetail> itemDetailList = new ArrayList<>();
		for(String itemCode : itemAmountMap.keySet()) {
			Item item = itemService.findByItemCode(itemCode);
			Discount discount = itemDiscountRecordService.getItemDiscount(itemCode);
			ItemDetail itemDetail = discount.generateItemDetail(item, itemAmountMap.get(itemCode));
			itemDetailList.add(itemDetail);
		}
		return itemDetailList;
	}
	Map<String, Integer> getItemAmountMap(List<String> itemList) {
		Map<String, Integer> itemAmountMap = new HashMap<String, Integer>();
		try {
			for(String itemCodeAmount : itemList) {
				if (!itemCodeAmount.contains("-")) {
					addItemAmount(itemAmountMap, itemCodeAmount, 1);
				}
				else {
					String[] items = itemCodeAmount.split("-");
					addItemAmount(itemAmountMap, items[0], Integer.parseInt(items[1]));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("输入数据格式错误");
		}
		return itemAmountMap;
	}
	void addItemAmount(Map<String, Integer> itemAmountMap, String itemCode, int amount) {
		Integer originalAmount = itemAmountMap.get(itemCode);
		if (originalAmount != null) {
			originalAmount = 0;
		}
		itemAmountMap.put(itemCode, originalAmount + amount);
	}
	
	

}

 /**
 * @author elvis.zhang
 * Description: 
 * 商品和折扣关联类服务实现
 * 2016年3月11日下午5:26:42
 */
package com.ralvis.cashier.setting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import com.ralvis.cashier.discount.Discount;

public class MockItemDiscountRecordService implements ItemDiscountRecordService {
	private static ItemDiscountRecordService instance = new MockItemDiscountRecordService();
	private Map<String, Set<Discount>> maps = new HashMap<>();
	private Discount topDiscount;
	
	public static ItemDiscountRecordService getInstance() {
		return instance;
	}
	
	private MockItemDiscountRecordService() {
		this.topDiscount = Settings.getTopPriorityDiscount();
	}
	
	public void reset() {
		maps.clear();
		topDiscount = Settings.getTopPriorityDiscount();
	}
	
	@Override
	public void setItemDiscount(String itemCode, Discount discount) {
		Set<Discount> set = maps.get(itemCode);
		if (set == null) {
			set = new HashSet<>();
		}
		set.add(discount);
		maps.put(itemCode, set);
	}

	@Override
	public void setTopPriorityDiscount(Discount discount) {
		this.topDiscount = discount;
		Settings.saveTopPriorityDiscount(discount);
	}

	@Override
	public Discount getItemDiscount(String itemCode) {
		Set<Discount> discounts = maps.get(itemCode);
		if (discounts == null || discounts.isEmpty()) {
			return DiscountFacotory.ORIGINAL_DISCOUNT;
		}
		else if (discounts.size() == 1) {
			return discounts.iterator().next();
		}
		else {
			return topDiscount;
		}
	}

}

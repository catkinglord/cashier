 /**
 * @author elvis.zhang
 * Description: 
 * 商品和折扣关联类服务
 * 2016年3月11日下午5:16:25
 */
package com.ralvis.cashier.setting;

import com.ralvis.cashier.discount.Discount;

public interface ItemDiscountRecordService {

	void setItemDiscount(String itemCode, Discount discount);
	
	//一个商品多种折扣时，默认享受哪种
	void setTopPriorityDiscount(Discount discount);
	
	Discount getItemDiscount(String itemCode);
	
	void reset();
}

 /**
 * @author elvis.zhang
 * Description: 
 * 测试商品和折扣关联类服务实现
 * 2016年3月11日下午5:54:14
 */
package com.ralvis.cashier.setting;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.discount.Discount;

public class MockItemDiscountRecordServiceTest {
	@Test
	public void testSetItemDiscount() {
		ItemDiscountRecordService service = MockItemDiscountRecordService.getInstance();
		service.reset();
		service.setItemDiscount("item1", DiscountFacotory.NORMAL_DISCOUNT);
		Discount discount = service.getItemDiscount("item1");
		Assert.assertEquals(discount, DiscountFacotory.NORMAL_DISCOUNT);
	}
	
	@Test
	public void testSetItem2Discount() {
		ItemDiscountRecordService service = MockItemDiscountRecordService.getInstance();
		service.reset();
		service.setItemDiscount("item1", DiscountFacotory.NORMAL_DISCOUNT);
		service.setItemDiscount("item1", DiscountFacotory.MFORNFREE_DISCOUNT);
		Discount discount = service.getItemDiscount("item1");
		Assert.assertEquals(discount, DiscountFacotory.MFORNFREE_DISCOUNT);
	}
	
	@Test
	public void testSetItemDefaultDiscount() {
		ItemDiscountRecordService service = MockItemDiscountRecordService.getInstance();
		service.reset();
		service.setItemDiscount("item1", DiscountFacotory.NORMAL_DISCOUNT);
		service.setItemDiscount("item1", DiscountFacotory.ORIGINAL_DISCOUNT);
		Discount discount = service.getItemDiscount("item1");
		Assert.assertEquals(discount, DiscountFacotory.MFORNFREE_DISCOUNT);
	}
	
	@Test
	public void testSetItemDefault2Discount() {
		ItemDiscountRecordService service = MockItemDiscountRecordService.getInstance();
		service.reset();
		service.setItemDiscount("item1", DiscountFacotory.NORMAL_DISCOUNT);
		service.setItemDiscount("item1", DiscountFacotory.ORIGINAL_DISCOUNT);
		service.setTopPriorityDiscount(DiscountFacotory.ORIGINAL_DISCOUNT);
		Discount discount = service.getItemDiscount("item1");
		Assert.assertEquals(discount, DiscountFacotory.ORIGINAL_DISCOUNT);
	}
	
	
}

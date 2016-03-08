 /**
 * @author elvis.zhang
 * Description: 
 * 测试商品按照原价计算，不享受折扣
 * 2016年3月8日下午4:13:09
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;

public class OriginalCostDiscountTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeAmountNegative() {
		Discount discount = new OriginalCostDiscount();
		BigDecimal result = discount.compute(-2, BigDecimal.ONE);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeAmountZero() {
		Discount discount = new OriginalCostDiscount();
		BigDecimal result = discount.compute(0, BigDecimal.ONE);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeUnitPriceNull() {
		Discount discount = new OriginalCostDiscount();
		BigDecimal result = discount.compute(0, null);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeUnitPriceZero() {
		Discount discount = new OriginalCostDiscount();
		BigDecimal result = discount.compute(0, BigDecimal.ZERO);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testComputeCustom() {
		Discount discount = new OriginalCostDiscount();
		BigDecimal result = discount.compute(5, new BigDecimal("1.2"));
		Assert.assertEquals(result, new BigDecimal("6.0"));
	}
}

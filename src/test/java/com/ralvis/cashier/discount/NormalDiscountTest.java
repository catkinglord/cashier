 /**
 * @author elvis.zhang
 * Description: 
 * 测试商品按照正常折扣计算价格
 * 2016年3月8日下午4:40:09
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;

public class NormalDiscountTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeAmountNegative() {
		Discount discount = new NormalDiscount(10);
		BigDecimal result = discount.compute(-2, BigDecimal.ONE);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeAmountZero() {
		Discount discount = new NormalDiscount(10);
		BigDecimal result = discount.compute(0, BigDecimal.ONE);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeUnitPriceNull() {
		Discount discount = new NormalDiscount(10);
		BigDecimal result = discount.compute(1, null);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeUnitPriceZero() {
		Discount discount = new NormalDiscount(10);
		BigDecimal result = discount.compute(1, BigDecimal.ZERO);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeDiscountPositive() {
		Discount discount = new NormalDiscount(-1);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeDiscountZero() {
		Discount discount = new NormalDiscount(0);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeDiscountEQMax() {
		Discount discount = new NormalDiscount(100);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeDiscountGTMax() {
		Discount discount = new NormalDiscount(101);
		Assert.assertNotNull(discount);
	}
	
	@Test
	public void testComputeCustom() {
		Discount discount = new NormalDiscount(60);
		BigDecimal result = discount.compute(5, new BigDecimal("1.2"));
		Assert.assertEquals(result, new BigDecimal("3.6"));
	}
}

 /**
 * @author elvis.zhang
 * Description: 
 * 测试商买m送n的折扣方式-例如买二送一 
 * 2016年3月8日下午5:10:09
 */
package com.ralvis.cashier.discount;

import java.math.BigDecimal;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;

public class BuyMForNFreeDiscountTest extends BaseTestNG{

	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeAmountNegative() {
		Discount discount = new BuyMForNFreeDiscount(2, 1);
		BigDecimal result = discount.compute(-2, BigDecimal.ONE);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeAmountZero() {
		Discount discount = new BuyMForNFreeDiscount(2, 1);
		BigDecimal result = discount.compute(0, BigDecimal.ONE);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeUnitPriceNull() {
		Discount discount = new BuyMForNFreeDiscount(2, 1);
		BigDecimal result = discount.compute(1, null);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeUnitPriceZero() {
		Discount discount = new BuyMForNFreeDiscount(2, 1);
		BigDecimal result = discount.compute(1, BigDecimal.ZERO);
		Assert.assertNotNull(result);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeBuyMPositive() {
		Discount discount = new BuyMForNFreeDiscount(-2, 1);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeBuyMZero() {
		Discount discount = new BuyMForNFreeDiscount(0, 1);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeForFreeNPositive() {
		Discount discount = new BuyMForNFreeDiscount(5, -1);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeForFreeNZero() {
		Discount discount = new BuyMForNFreeDiscount(5, 0);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeBuyMEQForFreeNZero() {
		Discount discount = new BuyMForNFreeDiscount(5, 5);
		Assert.assertNotNull(discount);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testComputeBuyMLTForFreeNZero() {
		Discount discount = new BuyMForNFreeDiscount(5, 6);
		Assert.assertNotNull(discount);
	}
	
	@Test
	public void testComputeCustom() {
		Discount discount = new BuyMForNFreeDiscount(2, 1);
		BigDecimal result = discount.compute(5, new BigDecimal("1.2"));
		Assert.assertEquals(result, new BigDecimal("3.6"));
	}
}

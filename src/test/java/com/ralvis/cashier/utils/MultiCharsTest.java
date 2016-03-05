/**
 * @author elvis.zhang
 * Description: 
 * 测试字符串拼接
 * 2016年3月5日下午1:35:54
 */
package com.ralvis.cashier.utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ralvis.cashier.base.BaseTestNG;

public class MultiCharsTest extends BaseTestNG{
	@Test
	public void testNegative() {
		String joinedChars = MultiChars.initToString(-1, '-');
		Assert.assertEquals(joinedChars, "");
	}
	
	@Test
	public void testZero() {
		String joinedChars = MultiChars.initToString(0, '-');
		Assert.assertEquals(joinedChars, "");
	}
	
	@Test
	public void testPositive() {
		String joinedChars = MultiChars.initToString(3, '-');
		Assert.assertEquals(joinedChars, "---");
	}
}

package com.ralvis.cashier.print;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ralvis.cashier.base.BaseTestNG;

/**
 * 
 * @author elvis.zhang
 * Description: 
 * 测试TestNG是否可用
 * 2016年3月5日上午11:44:44
 */
public class AppTest extends BaseTestNG{

	@Test
	public void test2() {
		Assert.assertEquals(1>0, true);
	}
}

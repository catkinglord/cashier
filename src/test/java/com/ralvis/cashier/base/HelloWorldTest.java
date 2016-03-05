package com.ralvis.cashier.base;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author elvis.zhang
 * Description: 
 * 测试TestNG是否可用
 * 2016年3月5日上午11:44:44
 */
public class HelloWorldTest extends BaseTestNG{

	@Test
	public void testEnvironmentOK() {
		Assert.assertEquals(HelloWorld.greeting(), 
				HelloWorld.DEFAULT_GREETING);
	}
}

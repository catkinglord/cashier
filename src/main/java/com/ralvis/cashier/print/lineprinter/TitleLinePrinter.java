 /**
 * @author elvis.zhang
 * Description: 
 * 打印小票-打印一行文字-例如买二赠一商品：
 * 2016年3月8日上午11:39:53
 */
package com.ralvis.cashier.print.lineprinter;

import org.apache.commons.lang.StringUtils;

public class TitleLinePrinter implements LinePrinter {

	private String title;
	
	public TitleLinePrinter(String title) {
		this.title = title;
		if (StringUtils.isEmpty(title)) {
			throw new RuntimeException("title不能为空");
		}
	}
	
	@Override
	public String print() {
		return String.format("%s：", title);
	}
}

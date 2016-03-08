 /**
 * @author elvis.zhang
 * Description: 
 * 打印小票-输出文本格式-例如-购物清单
 * 2016年3月8日下午1:19:17
 */
package com.ralvis.cashier.print.printer;

import org.apache.commons.lang.StringUtils;

public class TextPrinter implements Printer{

	private String text;
	
	public TextPrinter(String text) {
		this.text = text;
		if (StringUtils.isEmpty(text)) {
			throw new RuntimeException("text不能为空");
		}
	}
	
	@Override
	public String print() {
		return String.format("%s", text);
	}
}

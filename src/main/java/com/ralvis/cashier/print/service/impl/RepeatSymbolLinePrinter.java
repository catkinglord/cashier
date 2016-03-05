/**
 * @author elvis.zhang
 * Description: 
 * 2016年3月5日下午2:42:48
 */
package com.ralvis.cashier.print.service.impl;

import com.ralvis.cashier.print.service.LinePrinter;
import com.ralvis.cashier.utils.MultiChars;

public class RepeatSymbolLinePrinter implements LinePrinter{
	private final static int DEFAULT_REPEAT_TIMES = 22;
	private int length;
	private char character;
	
	public RepeatSymbolLinePrinter(int repeatTimes, char character) {
		this.length = repeatTimes;
		this.character = character;
	}
	
	public RepeatSymbolLinePrinter() {
		this.length = DEFAULT_REPEAT_TIMES;
		this.character = '-';
	}
	
	@Override
	public String generateLine() {
		return MultiChars.initToString(length, character);
	}
}

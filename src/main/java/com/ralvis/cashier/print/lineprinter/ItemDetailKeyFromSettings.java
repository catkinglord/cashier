 /**
 * @author elvis.zhang
 * Description: 
 * 2016年3月11日上午11:30:19
 */
package com.ralvis.cashier.print.lineprinter;

import com.ralvis.cashier.utils.Settings;

public class ItemDetailKeyFromSettings implements ItemDetailKey{

	@Override
	public String getNameKey() {
		return Settings.getNameKey();
	}
	
	@Override
	public String getAmountKey() {
		return Settings.getAmountKey();
	}
	
	@Override
	public String getUnitPriceKey() {
		return Settings.getUnitPriceKey();
	}
	
	@Override
	public String getTotalKey() {
		return Settings.getItemDetailTotalKey();
	}
	
	@Override
	public int getMoneyDecimal() {
		return Settings.getMoneyDecimal();
	}
	
	@Override
	public String getMoneyUom() {
		return Settings.getMoneyUom();
	}
}

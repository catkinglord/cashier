 /**
 * @author elvis.zhang
 * Description: 
 * 商品类
 * 2016年3月8日下午5:55:29
 */
package com.ralvis.cashier.item.entity;

import java.math.BigDecimal;

public class Item {
	//物品条码
	private String itemCode;
	//物品名称
	private String itemName;
	//物品数量单位
	private String amountUom;
	//单价金额
	private BigDecimal unitPrice;
	
	/**
	 * @param itemCode 
	 * @param itemName
	 * @param amountUom
	 */
	public Item(String itemCode, String itemName, String amountUom,
			BigDecimal unitPrice) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.amountUom = amountUom;
		this.unitPrice = unitPrice;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getAmountUom() {
		return amountUom;
	}
	public void setAmountUom(String amountUom) {
		this.amountUom = amountUom;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}

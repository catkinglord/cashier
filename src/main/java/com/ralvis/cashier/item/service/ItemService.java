 /**
 * @author elvis.zhang
 * Description: 
 * 商品类的服务
 * 2016年3月8日下午6:01:43
 */
package com.ralvis.cashier.item.service;

import com.ralvis.cashier.item.entity.Item;

public interface ItemService {

	Item findByItemCode(String itemCode);
}

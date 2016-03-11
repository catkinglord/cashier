 /**
 * @author elvis.zhang
 * Description: 
 * 2016年3月11日下午6:06:23
 */
package com.ralvis.cashier.input;

import com.ralvis.cashier.order.Order;

public interface Input {

	Order getOrder(String orderJson);
}

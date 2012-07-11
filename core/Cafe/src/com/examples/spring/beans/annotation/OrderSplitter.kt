package com.examples.spring.beans.annotation

/**
 * @author Natalia.Ukhorskaya
 */

import java.util.List;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import com.examples.spring.beans.Order;
import com.examples.spring.beans.OrderItem;

/**
 * @author Mark Fisher
 */

MessageEndpoint
public class OrderSplitter {

    Splitter(inputChannel="orders", outputChannel="drinks")
    public fun split(order: Order): List<OrderItem> {
        return order.items;
    }

}

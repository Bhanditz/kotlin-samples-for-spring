package com.examples.spring.beans.annotation

import org.springframework.integration.annotation.MessageEndpoint
import org.springframework.integration.annotation.Router
import com.examples.spring.beans.OrderItem

/**
 * @author Natalia.Ukhorskaya
 */

MessageEndpoint
public class DrinkRouter {

    Router(inputChannel="drinks")
    public fun resolveOrderItemChannel(orderItem: OrderItem): String {
        return if (orderItem.iced) "coldDrinks" else "hotDrinks"
    }

} 

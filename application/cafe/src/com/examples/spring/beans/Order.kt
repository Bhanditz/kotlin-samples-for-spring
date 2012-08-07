package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

import java.util.ArrayList;
import java.util.List;

class Order(val number: Int) {

    public val items: List<OrderItem> = ArrayList<OrderItem>()

    public fun addItem(vararg orderItems: OrderItem) {
        orderItems.forEach {
            items.add(it)
        }
    }
}

 

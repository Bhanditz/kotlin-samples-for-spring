package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

import java.util.ArrayList;

class Order(val number: Int) {

    public val items: MutableList<OrderItem> = ArrayList<OrderItem>()

    public fun addItem(vararg orderItems: OrderItem) {
        orderItems.forEach {
            items.add(it)
        }
    }
}

 

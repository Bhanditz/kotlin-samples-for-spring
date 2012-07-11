package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

import java.util.ArrayList;
import java.util.List;

// Default constructor required by Jackson Java JSON-processor
class Order(val number: Int) {

    public val items: List<OrderItem> = ArrayList<OrderItem>();

    public fun addItem(drinkType: DrinkType, shots: Int, iced: Boolean) {
        items.add(OrderItem(number, drinkType, shots, iced));
    }
}

 

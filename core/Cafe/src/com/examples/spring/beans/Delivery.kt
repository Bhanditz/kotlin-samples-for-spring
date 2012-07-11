package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

import java.util.List;

class Delivery(private val deliveredDrinks: List<Drink>) {

    class object {
        private val SEPARATOR: String = "-----------------------\n"
    }
    
    public val orderNumber: Int = deliveredDrinks.get(0)?.orderNumber ?: 0

    fun toString(): String {
        val buffer = StringBuffer(SEPARATOR)
        buffer.append("Order #")
        buffer.append(orderNumber)
        buffer.append("\n")
        for (drink in deliveredDrinks) {
            buffer.append(drink)
            buffer.append("\n")
        }
        buffer.append(SEPARATOR)
        return buffer.toString() ?: ""
    }
}

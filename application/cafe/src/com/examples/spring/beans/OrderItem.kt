package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

class OrderItem(val orderNumber: Int, val drinkType: DrinkType, val shots: Int, val iced: Boolean) {
    override fun toString(): String {
        return "${if (iced) "iced " else "hot "} $shots shot $drinkType"
    }
}

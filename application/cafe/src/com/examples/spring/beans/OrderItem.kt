package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

class OrderItem(val orderNumber: Int, val drinkType: DrinkType, val shots: Int, val iced: Boolean) {
    
    public fun toString(): String {
        return "${if (iced) "iced " else "hot "} ${this.shots} shot $drinkType"
    }

}


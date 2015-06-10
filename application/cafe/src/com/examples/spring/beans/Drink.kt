package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */


class Drink(var orderNumber: Int, var drinkType: DrinkType, var iced: Boolean, var shots: Int) {
    override fun toString(): String {
        return "${if (iced) "Iced " else "Hot "} $drinkType, $shots shots."
    }
}

enum class DrinkType {
    ESPRESSO,
    LATTE,
    CAPPUCCINO,
    MOCHA
}

package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */


class Drink(var orderNumber: Int, var drinkType: DrinkType, var iced: Boolean, var shots: Int) {
    fun toString(): String {
        return (if (iced) "Iced" else "Hot")  + " " + drinkType.toString() + ", " + shots + " shots." 
    }
}

// Workaround for KT-1971 Add right 'toString' to 'enums'
enum class DrinkType(val name: String) {
    ESPRESSO : DrinkType("ESPRESSO")
    LATTE : DrinkType("LATTE") 
    CAPPUCCINO : DrinkType("CAPPUCCINO")
    MOCHA : DrinkType("MOCHA") 
    
    fun toString(): String {
        return name
    }
}




package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

class Delivery(private val deliveredDrinks: List<Drink>) {

    override fun toString(): String {
        return deliveredDrinks.joinToString(separator = "\n",
                                          prefix = "\nOrder #${deliveredDrinks.first().orderNumber}\n",
                                          postfix = "\n-----------------------\n")
    }
}

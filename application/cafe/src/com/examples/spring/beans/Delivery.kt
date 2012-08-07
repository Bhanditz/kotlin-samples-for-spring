package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

import java.util.List;

class Delivery(private val deliveredDrinks: List<Drink>) {

    fun toString(): String {
        return deliveredDrinks.makeString(separator = "\n",
                                          prefix = "\nOrder #${deliveredDrinks.first().orderNumber}\n",
                                          postfix = "\n-----------------------\n")
    }
}

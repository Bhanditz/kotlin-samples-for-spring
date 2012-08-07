package com.examples.spring.beans.annotation

/**
 * @author Natalia.Ukhorskaya
 */

import java.util.concurrent.atomic.AtomicInteger;

import com.examples.spring.beans.Drink;
import com.examples.spring.beans.OrderItem;
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.stereotype.Component

Component
class Barista() {
    private val hotDrinkDelay: Long = 1000
    private val coldDrinkDelay: Long = 500

    private val hotDrinkCounter: AtomicInteger = AtomicInteger();
    private val coldDrinkCounter: AtomicInteger = AtomicInteger();

    ServiceActivator(inputChannel = "hotDrinkBarista", outputChannel = "preparedDrinks")
    public fun prepareHotDrink(orderItem: OrderItem): Drink? {
        return prepareDrink(orderItem)
    }

    ServiceActivator(inputChannel = "coldDrinkBarista", outputChannel = "preparedDrinks")
    public fun prepareColdDrink(orderItem: OrderItem): Drink? {
        return prepareDrink(orderItem)
    }

    fun prepareDrink(orderItem: OrderItem): Drink? {
        try {
            if (orderItem.iced) Thread.sleep(coldDrinkDelay) else Thread.sleep(hotDrinkDelay)
            println("${Thread.currentThread().getName()} prepared ${ if (orderItem.iced) "cold" else "hot" } drink #${hotDrinkCounter.incrementAndGet()} "
                        +"for order #${orderItem.orderNumber}: $orderItem")
            return Drink(orderItem.orderNumber, orderItem.drinkType, orderItem.iced, orderItem.shots)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt();
            return null
        }
    }


}

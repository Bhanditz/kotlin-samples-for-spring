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
    private var hotDrinkDelay: Long = 5000
        public set

    private var coldDrinkDelay: Long = 1000
        public set

    private val hotDrinkCounter: AtomicInteger = AtomicInteger();
    private val coldDrinkCounter: AtomicInteger = AtomicInteger();

    ServiceActivator(inputChannel="hotDrinkBarista", outputChannel="preparedDrinks")
    public fun prepareHotDrink(orderItem: OrderItem): Drink? {
        try {
            Thread.sleep(hotDrinkDelay);
            System.out.println(Thread.currentThread()?.getName()
                + " prepared hot drink #" + hotDrinkCounter.incrementAndGet() + " for order #"
                + orderItem.orderNumber + ": " + orderItem)
            return Drink(orderItem.orderNumber, orderItem.drinkType, orderItem.iced, orderItem.shots)
        } catch (e: InterruptedException) {
            Thread.currentThread()?.interrupt();
            return null
        }
    }

    ServiceActivator(inputChannel="coldDrinkBarista", outputChannel="preparedDrinks")
    public fun prepareColdDrink(orderItem: OrderItem): Drink? {
        try {
            Thread.sleep(coldDrinkDelay);
            System.out.println(Thread.currentThread()?.getName()
                + " prepared cold drink #" + hotDrinkCounter.incrementAndGet() + " for order #"
                + orderItem.orderNumber + ": " + orderItem)
            return Drink(orderItem.orderNumber, orderItem.drinkType, orderItem.iced, orderItem.shots)
        } catch (e: InterruptedException) {
            Thread.currentThread()?.interrupt();
            return null
        }
    }

}

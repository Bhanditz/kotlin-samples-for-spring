package com.examples.spring.beans.annotation

import com.examples.spring.beans.DrinkType
import com.examples.spring.beans.Order
import com.examples.spring.beans.Cafe
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * @author Natalia.Ukhorskaya
 */

class CafeDemoApp(){}

fun  main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("/cafeDemo-annotation.xml", javaClass<CafeDemoApp>());

    val cafe = context.getBean("cafe") as Cafe
    for (i in 1..100) {
        val order = Order(i)
        order.addItem(DrinkType.LATTE, 10, false)
        order.addItem(DrinkType.CAPPUCCINO, 5, true)
        order.addItem(DrinkType.ESPRESSO, 1, true)
        cafe.placeOrder(order)
    }
    context.close();
}

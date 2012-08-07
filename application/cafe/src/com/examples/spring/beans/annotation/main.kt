package com.examples.spring.beans.annotation

import com.examples.spring.beans.DrinkType
import com.examples.spring.beans.Order
import com.examples.spring.beans.Cafe
import org.springframework.context.support.ClassPathXmlApplicationContext
import com.examples.spring.beans.OrderItem

/**
 * @author Natalia.Ukhorskaya
 */

fun  main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("/cafeDemo-annotation.xml");

    val cafe = context.getBean("cafe") as Cafe
    for (i in 1..50) {
        val order = Order(i)
        order.addItem(OrderItem(order.number, DrinkType.LATTE, 2, false),
                      OrderItem(order.number, DrinkType.CAPPUCCINO, 5, true),
                      OrderItem(order.number, DrinkType.ESPRESSO, 1, true))
        cafe.placeOrder(order)
    }
    context.close();
}

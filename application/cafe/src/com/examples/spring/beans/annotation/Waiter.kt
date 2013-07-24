package com.examples.spring.beans.annotation

/**
 * @author Natalia.Ukhorskaya
 */

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.MessageEndpoint;
import com.examples.spring.beans.Delivery;
import com.examples.spring.beans.Drink;

MessageEndpoint
public class Waiter {

    Aggregator(inputChannel = "preparedDrinks", outputChannel = "deliveries")
    public fun prepareDelivery(drinks: List<Drink>): Delivery {
        return Delivery(drinks);
    }

    CorrelationStrategy
    public fun correlateByOrderNumber(drink: Drink): Int {
        return drink.orderNumber
    }

}

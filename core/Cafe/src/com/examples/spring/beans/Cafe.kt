package com.examples.spring.beans

/**
 * @author Natalia.Ukhorskaya
 */

import org.springframework.integration.annotation.Gateway;

trait Cafe {
    Gateway(requestChannel = "orders")
    fun placeOrder(order: Order)
}

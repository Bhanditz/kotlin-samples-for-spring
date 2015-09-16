package com.examples.spring.basic.jms

import org.springframework.integration.annotation.MessageEndpoint
import org.springframework.integration.annotation.ServiceActivator

@MessageEndpoint
class DemoBean() {

    @ServiceActivator
    fun upperCase(input: String): String {
        return "JMS response: " + input.toUpperCase()
    }
}

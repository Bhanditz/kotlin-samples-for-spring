package com.examples.spring.basic.helloWord

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.integration.MessageChannel
import org.springframework.integration.core.PollableChannel
import org.springframework.integration.message.GenericMessage

/**
* @author Natalia.Ukhorskaya
*/

class HelloService() {
    fun sayHello(name: String): String {
        return "Hello, " + name;
    }
}

fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("/helloWorld.xml")
    val inputChannel = context.getBean("inputChannel", MessageChannel::class.java) as MessageChannel
    val outputChannel = context.getBean("outputChannel", PollableChannel::class.java) as PollableChannel
    inputChannel.send(GenericMessage<String>("guest"))
    println("Output: ${outputChannel.receive()?.getPayload()}")
}
 

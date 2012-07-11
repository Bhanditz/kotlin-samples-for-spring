package com.examples.spring.core

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.integration.MessageChannel
import org.springframework.integration.core.PollableChannel
import org.springframework.integration.message.GenericMessage

/**
* @author Natalia.Ukhorskaya
*/

class HelloWorldApp() {

}

class HelloService() {
    fun sayHello(name: String): String {
        return "Hello, " + name;
    }
}

fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("/helloWorld.xml", javaClass<HelloWorldApp>());
    val inputChannel = context.getBean("inputChannel", javaClass<MessageChannel>());
    val outputChannel = context.getBean("outputChannel", javaClass<PollableChannel>());
    inputChannel?.send(GenericMessage<String>("guest"))
    System.out.println("Output: " + outputChannel?.receive(0)?.getPayload());
}
 

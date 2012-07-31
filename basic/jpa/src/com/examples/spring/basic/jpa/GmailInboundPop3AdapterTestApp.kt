package com.examples.spring.basic.jpa

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.integration.Message
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.core.MessageHandler

fun main(args: Array<String>) {
    val ac = ClassPathXmlApplicationContext("/gmail-pop3-config.xml")
    val inputChannel = ac.getBean("recieveChannel", javaClass<DirectChannel>()) as? DirectChannel
    inputChannel?.subscribe(object : MessageHandler {
        public override fun handleMessage(p0: Message<out Any?>?) {
            println("Message: " + p0)
        }
    })
}

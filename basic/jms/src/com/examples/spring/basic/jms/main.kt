package com.examples.spring.basic.jms

import org.springframework.context.support.ClassPathXmlApplicationContext
import java.util.ArrayList

/**
 * User: Natalia.Ukhorskaya
 */

class Main() {

}

fun main(args: Array<String>) {
    prepare()
    val configFiles = array<String?>("/common.xml", "/inboundGateway.xml", "/outboundGateway.xml")
    ClassPathXmlApplicationContext(configFiles, javaClass<Main>())
    System.out.println("Please type something and hit return")
}

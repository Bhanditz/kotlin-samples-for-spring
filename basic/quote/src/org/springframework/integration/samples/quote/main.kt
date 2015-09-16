package org.springframework.integration.samples.quote

import org.springframework.context.support.ClassPathXmlApplicationContext

public fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("/quoteDemo.xml", Main::class.java)
    Thread.sleep((5000).toLong())
    context.close()
}

class Main() {

}

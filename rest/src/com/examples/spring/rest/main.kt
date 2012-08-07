package com.examples.spring.rest

import java.net.URL
import org.springframework.web.client.RestTemplate

/**
* User: Natalia.Ukhorskaya
*/

fun main(args: Array<String>) {
    println(URL("http://127.0.0.1:8081/message/Hello").readText())
    println(URL("http://127.0.0.1:8081/message/Hello,%20guest").readText())
    println(URL("http://127.0.0.1:8081/user/mike/cross").readText())
}
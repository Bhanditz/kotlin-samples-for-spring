package com.examples.spring.intermediate.async.gateway

import java.util.Random

public class MathService() {
    private val random = Random()

    fun multiplyByTwo(i: Int): Int {
        val sleep = (random.nextInt(10)) * 500
        Thread.sleep(sleep.toLong())
        return i * 2
    }
}

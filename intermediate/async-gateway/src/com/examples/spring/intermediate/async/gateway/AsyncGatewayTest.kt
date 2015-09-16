package com.examples.spring.intermediate.async.gateway

import org.springframework.context.ApplicationContext
import org.springframework.context.support.FileSystemXmlApplicationContext
import java.io.File
import java.util.HashMap
import java.util.Random
import java.util.concurrent.*

private val executor = Executors.newFixedThreadPool(100)
private val timeout = 20

fun main(args: Array<String>) {
    val ac: ApplicationContext? = FileSystemXmlApplicationContext("/math-service-config.xml")
    val mathService = ac?.getBean("mathService", MathServiceGateway::class.java) as MathServiceGateway
    val results = HashMap<Int, Future<Int>>()
    val random = Random()
    for (i in 0..50) {
        val number = random.nextInt(200)
        val result = mathService.multiplyByTwo(number)
        results.put(number, result)
    }
    for (resultEntry in results.entrySet()) {
        executor.execute(object : Runnable {
            public override fun run() {
                val result = processFuture(resultEntry)
                when(result[1]) {
                    -1 -> println("Multiplying " + result[0] + " should be easy. You should be able to multiply any number < 100 by 2 in your head")
                    -2 -> println("Multiplication of " + result[0] + " by 2 is can not be accomplished in " + timeout + " seconds")
                    else -> println("Result of multiplication of " + result[0] + " by 2 is " + result[1])
                }
            }
        })
    }
    executor.shutdown()
    executor.awaitTermination(60.toLong(), TimeUnit.SECONDS)
    println("Finished")
}

fun processFuture(resultEntry: Map.Entry<Int, Future<Int>>): IntArray {
    val originalNumber = resultEntry.getKey()
    val result = resultEntry.getValue()
    try {
        val finalResult = result.get(timeout.toLong(), TimeUnit.SECONDS)
        return intArrayOf(originalNumber, finalResult)
    }
    catch (e: ExecutionException) {
        return intArrayOf(originalNumber, -1)
    }
    catch (tex: TimeoutException) {
        return intArrayOf(originalNumber, -2)
    }
    catch (ex: Exception) {
        println()
        return intArrayOf(originalNumber, -2)
    }
}

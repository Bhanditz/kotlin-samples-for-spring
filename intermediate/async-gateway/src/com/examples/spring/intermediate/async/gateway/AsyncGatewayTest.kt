package com.examples.spring.intermediate.async.gateway

import org.springframework.context.ApplicationContext
import org.springframework.context.support.FileSystemXmlApplicationContext
import java.io.File
import java.util.HashMap
import java.util.Map
import java.util.Random
import java.util.concurrent.*

private val executor = Executors.newFixedThreadPool(100)
private val timeout = 20

fun main(args: Array<String>) {
    val ac: ApplicationContext? = FileSystemXmlApplicationContext("/math-service-config.xml")
    val mathService = ac?.getBean("mathService", javaClass<MathServiceGateway>()) as MathServiceGateway
    val results = HashMap<Int, Future<Int>>()
    val random = Random()
    for (i in 0..50) {
        var number: Int = random.nextInt(200)
        var result = mathService.multiplyByTwo(number)
        results.put(number, result)
    }
    for (resultEntry in results.entrySet()) {
        executor?.execute(object : Runnable {
            public override fun run() {
                val result = processFuture(resultEntry)
                if (result[1] == -1) {
                    System.out.println("Multiplying " + result[0] + " should be easy. You should be able to multiply any number < 100 by 2 in your head")
                }
                else if (result[1] == -2) {
                    System.out.println("Multiplication of " + result[0] + " by 2 is can not be accomplished in " + timeout + " seconds")
                }
                else {
                    System.out.println("Result of multiplication of " + result[0] + " by 2 is " + result[1])
                }
            }
        })
    }
    executor?.shutdown()
    executor?.awaitTermination(60.toLong(), TimeUnit.SECONDS)
    System.out.println("Finished")
}

fun processFuture(resultEntry: Map.Entry<Int, Future<Int>>): IntArray {
    val originalNumber = resultEntry.getKey()
    val result = resultEntry.getValue()
    try {
        val finalResult = result.get(timeout.toLong(), TimeUnit.SECONDS) ?: -1
        return intArray(originalNumber, finalResult)
    }
    catch (e: ExecutionException) {
        return intArray(originalNumber, -1)
    }
    catch (tex: TimeoutException) {
        return intArray(originalNumber, -2)
    }
    catch (ex: Exception) {
        System.out.println()
        return intArray(originalNumber, -2)
    }
}

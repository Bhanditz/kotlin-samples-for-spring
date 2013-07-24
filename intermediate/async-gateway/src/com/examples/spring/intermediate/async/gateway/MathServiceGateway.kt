package com.examples.spring.intermediate.async.gateway

import java.util.concurrent.Future

public trait MathServiceGateway {
    fun multiplyByTwo(i: Int): Future<Int>
}

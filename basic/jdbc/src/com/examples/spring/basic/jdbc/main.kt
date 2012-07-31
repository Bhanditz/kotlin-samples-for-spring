package com.examples.spring.basic.jdbc

import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * @author Natalia.Ukhorskaya
 */

fun main(args: Array<String>) {
    val appContext = ClassPathXmlApplicationContext("/jdbc_example.xml")

    val userBO = appContext.getBean("userBO") as UserBO

    var start = 0
    /** insert **/
    for(i in 0..5) {
        val newUser = User()
        newUser.name = "Mark"
        newUser.age = 15
        userBO.save(newUser)
        System.out.println(newUser)
        if (i == 0) {
            start = newUser.id
        }
    }

    /** select **/
    val userForFind = userBO.findById(start + 1)
    if (userForFind == null) {
        System.err.println("Impossible to find user with id " + start + 1)
    }
    System.out.println(userForFind)

    /** update **/
    val userForUpdate = userBO.findById(start + 2)
    if (userForUpdate == null) {
        System.err.println("Impossible to find user with id " + start + 2)
    } else {
        userForUpdate.name = "Kurt"
        userBO.update(userForUpdate)
        System.out.println(userForUpdate)
    }


    /** delete **/
    val userForDelete = userBO.findById(start + 3)
    if (userForDelete == null) {
        System.err.println("Impossible to find user with id " + start + 3)
    } else {
        userBO.delete(userForDelete)
        System.out.println(userForDelete)

    }

}


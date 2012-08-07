package com.examples.spring.basic.jdbc

import org.springframework.context.support.ClassPathXmlApplicationContext
import java.util.Random

/**
 * @author Natalia.Ukhorskaya
 */

val userBO: UserBO
    get() {
        val appContext = ClassPathXmlApplicationContext("/jdbc_example.xml")
        return appContext.getBean("userBO") as UserBO
    }

fun main(args: Array<String>) {
    var currentId = 0

    for(i in 0..5) {
        val id = addUser()
        if (i == 0) {
            currentId = id
        }
    }

    selectUser(currentId)

    currentId++

    updateUser(currentId, "Kurt", 15)

    currentId++

    deleteUser(currentId)
}

fun addUser(): Int {
    val newUser = User()
    newUser.name = "Mark"
    newUser.age = Random().nextInt(100)
    userBO.save(newUser)
    println("Create: $newUser")
    return newUser.id
}

fun selectUser(id: Int) {
    val userForFind = userBO.findById(id)
    if (userForFind == null) {
        println("Cannot find user with id $id")
    }
    println("Select: $userForFind")
}

fun updateUser(id: Int, newName: String, newAge: Int) {
    val userForUpdate = userBO.findById(id)
    println("Before update: $userForUpdate")
    if (userForUpdate == null) {
        println("Cannot find user with id $id")
    } else {
        userForUpdate.name = newName
        userForUpdate.age = newAge
        userBO.update(userForUpdate)
    }
    println("After update: $userForUpdate")
}

fun deleteUser(id: Int) {
    val userForDelete = userBO.findById(id)
    println("Before delete: $userForDelete")
    if (userForDelete == null) {
        println("Cannot find user with id $id")
    } else {
        userBO.delete(userForDelete)
    }
    println("After delete: ${userBO.findById(id) ?: "Cannot find user with id $id"}")
}


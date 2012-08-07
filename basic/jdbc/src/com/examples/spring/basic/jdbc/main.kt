package com.examples.spring.basic.jdbc

import org.springframework.context.support.ClassPathXmlApplicationContext
import java.util.Random

/**
 * @author Natalia.Ukhorskaya
 */

val userDAO: UserDAO
    get() {
        val appContext = ClassPathXmlApplicationContext("/jdbc_example.xml")
        return appContext.getBean("userDAO") as UserDAO
    }

fun main(args: Array<String>) {
    var currentId = addUser()
    addUser()
    addUser()
    addUser()

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
    userDAO.save(newUser)
    println("Create: $newUser")
    return newUser.id
}

fun selectUser(id: Int) {
    val userForFind = userDAO.findById(id)
    if (userForFind == null) {
        println("Cannot find user with id $id")
    }
    println("Select: $userForFind")
}

fun updateUser(id: Int, newName: String, newAge: Int) {
    val userForUpdate = userDAO.findById(id)
    println("Before update: $userForUpdate")
    if (userForUpdate == null) {
        println("Cannot find user with id $id")
    } else {
        userForUpdate.name = newName
        userForUpdate.age = newAge
        userDAO.update(userForUpdate)
    }
    println("After update: $userForUpdate")
}

fun deleteUser(id: Int) {
    val userForDelete = userDAO.findById(id)
    println("Before delete: $userForDelete")
    if (userForDelete == null) {
        println("Cannot find user with id $id")
    } else {
        userDAO.delete(userForDelete)
    }
    println("After delete: ${userDAO.findById(id) ?: "Cannot find user with id $id"}")
}


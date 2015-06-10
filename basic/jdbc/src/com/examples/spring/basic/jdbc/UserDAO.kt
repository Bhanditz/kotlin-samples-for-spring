package com.examples.spring.basic.jdbc

/**
 * @author Natalia.Ukhorskaya
 */

interface UserDAO {
    fun save(user: User)
    fun update(user: User)
    fun delete(user: User)
    fun findById(id: Int): User?
}

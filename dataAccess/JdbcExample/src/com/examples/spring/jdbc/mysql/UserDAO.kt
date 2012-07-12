package com.examples.spring.jdbc.mysql

/**
 * @author Natalia.Ukhorskaya
 */

trait UserDAO {
    fun save(user: User)
    fun update(user: User)
    fun delete(user: User)
    fun findById(id: Int): User?
}

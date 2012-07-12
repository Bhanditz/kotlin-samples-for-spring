package com.examples.spring.jdbc.mysql

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Natalia.Ukhorskaya
 */

Service("userBO")
class UserBOImpl(): UserBO{
    override fun update(user: User) {
        userDAO?.update(user);
    }
    override fun findById(id: Int): User? {
        return userDAO?.findById(id);
    }
    override fun save(user: User) {
        userDAO?.save(user);
    }
    override fun delete(user: User) {
        userDAO?.delete(user);
    }

    Autowired 
    private var userDAO: UserDAO? = null
        public set

}


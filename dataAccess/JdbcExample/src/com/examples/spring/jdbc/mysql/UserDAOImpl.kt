package com.examples.spring.jdbc.mysql

import java.util.List
import org.springframework.stereotype.Repository

Repository("userDAO")
class UserDAOImpl(): CustomHibernateDAOSupport(), UserDAO {

    override fun save(user: User) {
        getHibernateTemplate()?.save(user)
    }
    override fun update(user: User) {
        getHibernateTemplate()?.update(user)
    }
    override fun delete(user: User){
        getHibernateTemplate()?.delete(user)
    }
    public override fun findById(id: Int): User? {
        val list = getHibernateTemplate()?.find("from User where id=" + id)
        return if (list == null) null else list.get(0) as User?
    }


}

package com.examples.spring.basic.jdbc

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.hibernate3.support.HibernateDaoSupport
import org.springframework.stereotype.Service

@Service("userDAO")
class UserDAOImpl(): HibernateDaoSupport(), UserDAO {

    override fun save(user: User) {
        hibernateTemplate?.save(user)
    }
    override fun update(user: User) {
        hibernateTemplate?.update(user)
    }
    override fun delete(user: User){
        hibernateTemplate?.delete(user)
    }
    
    override fun findById(id: Int): User? {
        val list = hibernateTemplate?.find("from User where id=" + id)
        return if(list == null || list.isEmpty()) null else list.first() as User?
    }

    @Autowired
    public fun anyMethodName(sessionFactory: SessionFactory) {
        setSessionFactory(sessionFactory)
    }

}

package com.examples.spring.basic.jdbc

/**
 * @author Natalia.Ukhorskaya
 */

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.hibernate3.support.HibernateDaoSupport

public abstract class CustomHibernateDAOSupport(): HibernateDaoSupport() {
    Autowired
    public fun anyMethodName(sessionFactory: SessionFactory) {
        setSessionFactory(sessionFactory)
    }
}
 

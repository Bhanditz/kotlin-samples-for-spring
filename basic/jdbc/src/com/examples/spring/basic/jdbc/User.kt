package com.examples.spring.basic.jdbc

/**
 * @author Natalia.Ukhorskaya
 */

import javax.persistence.*;
import javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable

// uniqueConstraints = array(UniqueConstraint(columnNames = array("id")))
Entity
Table(name = "User")
public class User(): Serializable {

    public var id: Int = 0
        [Id
        GeneratedValue(strategy = GenerationType.IDENTITY)
        Column(name = "id", unique = true, nullable = false)]
        get

    public var name: String = ""
        [Column(name = "name", unique = false, nullable = false, length = 40)]
        get

    public var age: Int = 18
        [Column(name = "age", unique = false, nullable = false)]
        get

    override public fun toString(): String {
        return "User [id=$id, name=$name, age=$age]";
    }
    
}




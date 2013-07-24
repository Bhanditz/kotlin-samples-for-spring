package com.examples.spring.basic.jms

import java.io.File

/**
 * User: Natalia.Ukhorskaya
 */

fun prepare(): Unit {
    println("####### Refreshing ActiveMq ########")
    val activeMqTempDir = File("activemq-data")
    deleteDir(activeMqTempDir)
}

private fun deleteDir(directory: File?): Unit {
    if (directory?.exists()!!) {
        val children = directory?.list()
        if (children != null) {
            children.forEach { deleteDir(File(directory, it)) }
        }
    }

    directory?.delete()
}
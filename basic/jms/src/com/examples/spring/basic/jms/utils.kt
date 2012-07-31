package com.examples.spring.basic.jms

import java.io.File

/**
 * User: Natalia.Ukhorskaya
 */

fun prepare(): Unit {
    System.out.println("####### Refreshing ActiveMq ########")
    val activeMqTempDir = File("activemq-data")
    deleteDir(activeMqTempDir)
}

private fun deleteDir(directory: File?): Unit {
    if (directory?.exists().sure())
    {
        val children = directory?.list()
        if (children != null) {
            for (i in 0..children.size - 1) {
                deleteDir(File(directory, children[i]))
            }
        }
    }

    directory?.delete()
}
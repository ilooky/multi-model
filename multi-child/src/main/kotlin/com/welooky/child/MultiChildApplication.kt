package com.welooky.child

import com.welooky.library.Demo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiChildApplication

fun main(args: Array<String>) {
    runApplication<MultiChildApplication>(*args)
    Demo()
}

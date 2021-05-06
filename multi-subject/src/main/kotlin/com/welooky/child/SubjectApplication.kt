package com.welooky.child

import com.welooky.library.Demo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SubjectApplication

fun main(args: Array<String>) {
    runApplication<SubjectApplication>(*args)
    Demo()
}

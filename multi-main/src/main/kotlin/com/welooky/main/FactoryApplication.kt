package com.welooky.main

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScans

@SpringBootApplication
class FactoryApplication

fun main(args: Array<String>) {
    SpringApplication.run(FactoryApplication::class.java, *args)
}

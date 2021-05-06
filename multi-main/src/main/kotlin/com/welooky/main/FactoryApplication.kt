package com.welooky.main

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FactoryApplication

fun main(args: Array<String>) {
    SpringApplication.run(FactoryApplication::class.java, *args)
}

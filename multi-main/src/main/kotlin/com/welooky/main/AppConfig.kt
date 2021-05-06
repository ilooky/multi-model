package com.welooky.main

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(
    value = ["com.welooky.child"]
)
@Configuration
class AppConfig {
}
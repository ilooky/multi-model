package com.welooky.child

import kotlinx.coroutines.reactor.mono
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class Controller {
    @GetMapping("/info")
    fun findUser() = mono {
        "hello child user"
    }
}
package com.example.reactiverestservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveRestServiceApplication

fun main(args: Array<String>) {
    val context = runApplication<ReactiveRestServiceApplication>(*args)
    val greetingClient = context.getBean(GreetingClient::class.java)
    println(">> message = ${greetingClient.getMessage().block()}")
}

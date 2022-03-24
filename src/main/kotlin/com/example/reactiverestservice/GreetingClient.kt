package com.example.reactiverestservice

import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.client.WebClient.*
import reactor.core.publisher.*

@Suppress("unused")
@Component
class GreetingClient(builder: Builder) {

    val client = builder.baseUrl("http://localhost:8080").build()

    fun getMessage(): Mono<String> {
        return client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Greeting::class.java)
            .mapNotNull(Greeting::message)
    }

}
package com.example.reactiverestservice

import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.*
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.*

@Suppress("unused")
@Component
class GreetingHandler {

    fun hello(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(Greeting("Hello, Spring!")))
    }
}
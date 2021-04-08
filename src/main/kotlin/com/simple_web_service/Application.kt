package com.simple_web_service

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.simple_web_service.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}

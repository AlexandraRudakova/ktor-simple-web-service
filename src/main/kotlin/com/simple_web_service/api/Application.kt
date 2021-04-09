package com.simple_web_service.api

import com.simple_web_service.api.users.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.locations.Locations
import java.time.LocalDateTime

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            registerTypeAdapter(LocalDateTime::class.java, Json.LocalDateTimeSerializer)
        }
    }
    install(Locations)
    registerSpaceRoutes()
}

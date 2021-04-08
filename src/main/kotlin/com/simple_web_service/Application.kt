package com.simple_web_service

import com.simple_web_service.routes.*
import io.ktor.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    registerCustomerRoutes()
}

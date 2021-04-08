package com.simple_web_service.routes

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*

fun Route.spaceRouting() {
    route("/space") {
        get {
            call.respondText("Hello World!")
        }
    }
}

fun Application.registerCustomerRoutes() {
    routing {
        spaceRouting()
    }
}

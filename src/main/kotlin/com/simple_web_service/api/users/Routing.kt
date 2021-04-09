@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.simple_web_service.api.users

import com.simple_web_service.model.MockDb
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.response.*

fun Route.spaceUserRouting() {
    get<Locations.UserList>{
        val users = MockDb.getUsers().map { Locations.UserResponse.fromUser(it) }
        call.respond(Locations.UserListResponse(users))
    }

    get<Locations.UserById>{
            requestData ->
        val user = MockDb.getUser(requestData.id)
        val response =
            if (user != null)
                Locations.UserResponse.fromUser(user)
            else
                Locations.ErrorResponse("There is no page with id ${requestData.id}")
        call.respond(response)
    }
}

fun Application.registerSpaceRoutes() {
    routing {
        spaceUserRouting()
    }
}

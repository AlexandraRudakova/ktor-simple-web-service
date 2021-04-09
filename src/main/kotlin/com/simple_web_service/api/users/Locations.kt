package com.simple_web_service.api.users

import com.simple_web_service.model.User
import io.ktor.locations.Location

internal object Locations {
    const val usersPrefix = "/space/users"

    @Location("$usersPrefix")
    class UserList

    @Location("$usersPrefix/{id}")
    class UserById(val id: String)

    data class UserResponse(
        val id: String,
        val firstName: String,
        val lastName: String,
        val image: String,
        val smallImage: String
    ) {
        companion object {
            fun fromUser(user: User): UserResponse {
                return UserResponse(
                    user.id,
                    user.name.firstName,
                    user.name.lastName,
                    user.getAvatarUrl(),
                    user.getSmallAvatarUrl()
                )
            }
        }
    }

    data class UserListResponse(val data: List<UserResponse>)
    data class ErrorResponse(val error: String)
}

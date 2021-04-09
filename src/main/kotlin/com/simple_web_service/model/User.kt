package com.simple_web_service.model

const val spaceHost: String = "https://jetbrains.team"

data class User(
    val id: String,
    val username: String,
    val name: Name,
    val avatar: String?,
    val smallAvatar: String?

) {
    fun getAvatarUrl() = "${spaceHost}/d/$avatar"
    fun getSmallAvatarUrl() = "${spaceHost}/d/$smallAvatar"

    data class Name(val firstName: String, val lastName: String)
}
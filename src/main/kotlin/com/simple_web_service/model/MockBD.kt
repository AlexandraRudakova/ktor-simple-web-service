package com.simple_web_service.model

import com.simple_web_service.api.Json
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDateTime

object MockDb {
    private val storage = MockStorage()

    init {
        val mockData = readFromFile()
        storage.users.putAll(mockData.users.associateBy { it.id })
    }

    private fun readFromFile(): MockData {
        val mockDataFilePath = System.getenv("DUMMY_DATA_FILE")
        val dataFileContent = mockDataFilePath?.let { File(it).readText() }
            ?: {}.javaClass.getResource("/data.json").readText()
        val gson = with(GsonBuilder()) {
            registerTypeAdapter(LocalDateTime::class.java, Json.LocalDateTimeDeserializer)
            create()
        }
        return gson.fromJson(dataFileContent, MockData::class.java)
    }

    fun getUsers(): List<User> = storage.users.values.toList()
    fun getUser(userId: String): User? = storage.users.values.find{it.id == userId}

    data class MockData(val users: List<User>)
    data class MockStorage(
        val users: MutableMap<String, User> = mutableMapOf()
    )
}

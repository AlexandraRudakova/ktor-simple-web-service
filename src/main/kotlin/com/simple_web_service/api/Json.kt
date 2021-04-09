package com.simple_web_service.api

import com.google.gson.*
import java.lang.reflect.Type
import java.text.ParseException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Json {
    object LocalDateTimeSerializer: JsonSerializer<LocalDateTime?> {
        override fun serialize(src: LocalDateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
            return (if (src == null) {
                null
            } else {
                JsonPrimitive(src.format(DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm")))
            })!!
        }
    }

    object LocalDateTimeDeserializer: JsonDeserializer<LocalDateTime?> {
        override fun deserialize(element: JsonElement, arg1: Type?, arg2: JsonDeserializationContext?): LocalDateTime? {
            val date = element.asString
            val formatter = DateTimeFormatter.ISO_DATE_TIME
            return try {
                LocalDateTime.parse(date, formatter)
            } catch (e: ParseException) {
                null
            }
        }
    }
}

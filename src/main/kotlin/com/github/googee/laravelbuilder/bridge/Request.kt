package com.github.googee.laravelbuilder.bridge

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Suppress("PROVIDED_RUNTIME_TOO_LOW")
@Serializable
class Request(val action: String, val key: String, val data: String) {
    companion object {
        fun parse(text: String): Request {
            return Json.decodeFromString(serializer(), text)
        }
    }
}

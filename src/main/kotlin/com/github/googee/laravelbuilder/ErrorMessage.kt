package com.github.googee.laravelbuilder

class ErrorMessage {
    companion object {

        const val ActionNotFound = "Action Not Found"
        const val BadRequest = "Bad Request"
        const val OK = "OK"
        const val Unknown = "Unknown Error"

        fun check(message: String?): String {
            return message ?: Unknown
        }
    }

}
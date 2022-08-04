package com.github.googee.laravelbuilder.bridge

import java.awt.Desktop
import java.net.URI

class Open {
    val action = ActionEnum.open

    fun run(request: Request): Response {
        return try {
            Desktop.getDesktop().browse(URI(request.key))
            Response.ok(action.name, request.key, "")
        } catch (exception: Exception) {
            Response.error(action.name, request.key, "", exception.message)
        }
    }
}
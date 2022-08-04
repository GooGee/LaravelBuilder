package com.github.googee.laravelbuilder.bridge

import com.github.googee.laravelbuilder.file.FileManager

class Refresh {
    companion object {
        val action = ActionEnum.refresh

        fun run(): Response {
            FileManager.refresh()
            return Response.ok(action.name, "", "")
        }
    }
}

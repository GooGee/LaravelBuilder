package com.github.googee.laravelbuilder.bridge

import com.github.googee.laravelbuilder.ErrorMessage
import com.github.googee.laravelbuilder.file.FileManager
import com.intellij.openapi.project.Project

class RequestManager(fm: FileManager, project: Project) {

    private val edit: Edit
    private val open: Open

    init {
        edit = Edit(project)
        open = Open()
    }

    fun handle(request: Request): Response {
        if (request.action == edit.action.name) {
            return edit.run(request)
        }
        if (request.action == open.action.name) {
            return open.run(request)
        }
        if (request.action == Refresh.action.name) {
            return Refresh.run();
        }
        return Response.error(request.action, request.key, "", ErrorMessage.ActionNotFound)
    }
}
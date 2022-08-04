package com.github.googee.laravelbuilder.bridge

import com.github.googee.laravelbuilder.file.FileManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project

class Edit(val project: Project) {
    val action = ActionEnum.edit

    fun run(request: Request): Response {
        return try {
            ApplicationManager.getApplication().invokeLater(Runnable() {
                run() {
                    val file = FileManager.getFullPath(request.key, project)
                    if (FileManager.isFile(file) == false) {
                        FileManager.write(file, request.data)
                    }
                    val manager = FileEditorManager.getInstance(project)
                    val vf = FileManager.getVF(file) ?: return@Runnable
                    manager.openFile(vf, true)
                }
            })
            Response.ok(action.name, request.key, request.data)
        } catch (exception: Exception) {
            Response.error(action.name, request.key, "", exception.message)
        }
    }
}
package com.github.googee.laravelbuilder.services

import com.intellij.openapi.project.Project
import com.github.googee.laravelbuilder.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

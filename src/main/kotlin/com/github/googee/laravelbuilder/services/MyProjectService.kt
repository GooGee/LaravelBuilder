package com.github.googee.laravelbuilder.services

import com.intellij.openapi.project.Project
import com.github.googee.laravelbuilder.MyBundle
import com.github.googee.laravelbuilder.Start
import com.github.googee.laravelbuilder.view.BuilderView

class MyProjectService(val project: Project) {
    private var _view: BuilderView? = null
    val view: BuilderView
        get() {
            if (_view == null) {
                _view = Start.run(project)
            }
            return _view as BuilderView
        }

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

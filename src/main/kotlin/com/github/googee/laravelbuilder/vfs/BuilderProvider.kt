package com.github.googee.laravelbuilder.vfs

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class BuilderProvider : FileEditorProvider, DumbAware {
    override fun accept(project: Project, file: VirtualFile): Boolean {
        return file is BuilderVirtualFile
    }

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return BuilderEditor(project, file)
    }

    override fun getEditorTypeId(): String {
        return BuilderEditor.EditorType
    }

    override fun getPolicy(): FileEditorPolicy {
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR
    }
}
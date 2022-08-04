package com.github.googee.laravelbuilder.vfs

import com.github.googee.laravelbuilder.Constant
import com.github.googee.laravelbuilder.services.MyProjectService
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorLocation
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.vfs.VirtualFile
import java.beans.PropertyChangeListener
import javax.swing.JComponent

class BuilderEditor(val project: Project, val vf: VirtualFile) : UserDataHolderBase(), FileEditor {
    companion object {

        const val EditorType = Constant.Title
    }

    override fun dispose() {
    }

    override fun getComponent(): JComponent {
        return project.getService(MyProjectService::class.java).view
    }

    override fun getFile(): VirtualFile {
        return vf
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return project.getService(MyProjectService::class.java).view
    }

    override fun getName(): String {
        return Constant.Title
    }

    override fun setState(state: FileEditorState) {
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun isValid(): Boolean {
        return true
    }

    override fun addPropertyChangeListener(listener: PropertyChangeListener) {
    }

    override fun removePropertyChangeListener(listener: PropertyChangeListener) {
    }

    override fun getCurrentLocation(): FileEditorLocation? {
        return null
    }
}
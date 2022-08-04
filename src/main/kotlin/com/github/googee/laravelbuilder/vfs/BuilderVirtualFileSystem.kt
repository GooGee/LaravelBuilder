package com.github.googee.laravelbuilder.vfs

import com.intellij.openapi.vfs.NonPhysicalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.vfs.VirtualFileSystem
import java.io.IOException

class BuilderVirtualFileSystem : VirtualFileSystem(), NonPhysicalFileSystem {

    override fun getProtocol(): String {
        return "sb"
    }

    override fun findFileByPath(path: String): VirtualFile? {
        return null
    }

    override fun refresh(asynchronous: Boolean) {
    }

    override fun refreshAndFindFileByPath(path: String): VirtualFile? {
        return null
    }

    override fun addVirtualFileListener(listener: VirtualFileListener) {
    }

    override fun removeVirtualFileListener(listener: VirtualFileListener) {
    }

    override fun deleteFile(requestor: Any?, vFile: VirtualFile) {
    }

    override fun moveFile(requestor: Any?, vFile: VirtualFile, newParent: VirtualFile) {
    }

    override fun renameFile(requestor: Any?, vFile: VirtualFile, newName: String) {
    }

    override fun createChildFile(requestor: Any?, vDir: VirtualFile, fileName: String): VirtualFile {
        throw IOException()
    }

    override fun createChildDirectory(requestor: Any?, vDir: VirtualFile, dirName: String): VirtualFile {
        throw IOException()
    }

    override fun copyFile(
        requestor: Any?,
        virtualFile: VirtualFile,
        newParent: VirtualFile,
        copyName: String
    ): VirtualFile {
        throw IOException()
    }

    override fun isReadOnly(): Boolean {
        return true
    }
}
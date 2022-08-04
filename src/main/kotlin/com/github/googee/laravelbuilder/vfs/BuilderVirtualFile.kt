package com.github.googee.laravelbuilder.vfs

import com.github.googee.laravelbuilder.Constant
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileSystem
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class BuilderVirtualFile(private val vfs: BuilderVirtualFileSystem) : VirtualFile() {
    override fun getName(): String {
        return Constant.Title
    }

    override fun getFileSystem(): VirtualFileSystem {
        return vfs
    }

    override fun getPath(): String {
        return ""
    }

    override fun isWritable(): Boolean {
        return true
    }

    override fun isDirectory(): Boolean {
        return false
    }

    override fun isValid(): Boolean {
        return true
    }

    override fun getParent(): VirtualFile? {
        return null
    }

    override fun getChildren(): Array<VirtualFile> {
        throw IOException()
    }

    override fun getOutputStream(requestor: Any?, newModificationStamp: Long, newTimeStamp: Long): OutputStream {
        throw IOException()
    }

    override fun contentsToByteArray(): ByteArray {
        throw IOException()
    }

    override fun getTimeStamp(): Long {
        return 0
    }

    override fun getLength(): Long {
        return 0
    }

    override fun refresh(asynchronous: Boolean, recursive: Boolean, postRunnable: Runnable?) {
    }

    override fun getInputStream(): InputStream {
        throw IOException()
    }
}
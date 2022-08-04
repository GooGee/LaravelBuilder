package com.github.googee.laravelbuilder.file

import com.google.common.io.CharStreams
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths

class FileManager(val project: Project) {

    companion object {

        const val FolderName = "laravel-builder"

        fun getFullPath(file: String, project: Project): String {
            return project.basePath + File.separator + file
        }

        fun getVF(file: String): VirtualFile? {
            return VirtualFileManager.getInstance().refreshAndFindFileByNioPath(Paths.get(file))
        }

        fun isFile(file: String): Boolean {
            return File(file).isFile
        }

        fun makeFolder(file: String) {
            val path = Paths.get(file)
            Files.createDirectories(path.parent)
        }

        fun move(file: String, destination: String) {
            val old = File(file)
            val new = File(destination)
            makeFolder(destination)
            old.renameTo(new)
        }

        fun read(file: String): String {
            val stream = FileInputStream(file)
            return read(stream)
        }

        fun read(file: File): String {
            val stream = FileInputStream(file)
            return read(stream)
        }

        fun read(stream: FileInputStream): String {
            val reader = InputStreamReader(stream, "UTF-8")
            return CharStreams.toString(reader)
        }

        fun write(file: String, text: String) {
            val path = Paths.get(file)
            Files.createDirectories(path.parent)
            val writer = PrintWriter(path.toString())
            writer.print(text)
            writer.flush()
            writer.close()
            LocalFileSystem.getInstance().refreshAndFindFileByPath(file)
        }

        fun refresh() {
            println("-- refresh --")
            LocalFileSystem.getInstance().refresh(true)
        }
    }

    fun getFullPath(file: String): String {
        return project.basePath + File.separator + file
    }

    fun getBuilderFile(file: String): String {
        return getFullPath(FolderName + File.separator + file)
    }
}

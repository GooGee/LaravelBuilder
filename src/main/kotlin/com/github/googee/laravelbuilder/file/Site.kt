package com.github.googee.laravelbuilder.file

class Site {
    companion object {

        const val Key = "URI"
        const val URI = "http://localhost"

        fun getURI(fm: FileManager): String {
            val file = fm.getBuilderFile(Key)
            if (FileManager.isFile(file)) {
                return FileManager.read(file)
            }

            val uri = System.getenv(Key)
            if (uri.isNullOrEmpty()) {
                return URI
            }
            return uri
        }

        fun getFullURI(fm: FileManager): String {
            return getURI(fm) + "/build" + Version.get() + "?ide=idea"
        }
    }
}

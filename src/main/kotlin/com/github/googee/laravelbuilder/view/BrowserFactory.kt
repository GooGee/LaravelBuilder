package com.github.googee.laravelbuilder.view

import com.intellij.ui.jcef.JBCefBrowser

class BrowserFactory {
    companion object {
        fun make(uri: String): JBCefBrowser {
            println("URI: $uri")
            return JBCefBrowser(uri)
        }
    }
}
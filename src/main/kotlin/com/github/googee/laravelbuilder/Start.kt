package com.github.googee.laravelbuilder

import com.github.googee.laravelbuilder.bridge.CodeFactory
import com.github.googee.laravelbuilder.bridge.RequestManager
import com.github.googee.laravelbuilder.file.FileManager
import com.github.googee.laravelbuilder.file.Site
import com.github.googee.laravelbuilder.view.BuilderView
import com.github.googee.laravelbuilder.view.JCEFLoadHandler
import com.intellij.openapi.project.Project
import com.intellij.ui.jcef.JBCefBrowser

class Start {

    companion object {

        fun run(project: Project): BuilderView {
            val fm = FileManager(project)
            val uri = Site.getFullURI(fm)
            println("URI: $uri")
            val browser = JBCefBrowser(uri)
            val rm = RequestManager(fm, project)
            val cf = CodeFactory(browser, rm)
            val view = BuilderView(browser) {
                println("URI: $uri")
                Site.getFullURI(fm)
            }
            val handler = JCEFLoadHandler(view, cf)
            browser.jbCefClient.addLoadHandler(handler, browser.cefBrowser)
            return view
        }
    }
}
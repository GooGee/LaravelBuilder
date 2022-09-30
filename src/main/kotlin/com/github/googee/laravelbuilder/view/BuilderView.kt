package com.github.googee.laravelbuilder.view

import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import com.jetbrains.rd.util.printlnError
import java.awt.Color
import javax.swing.*

class BuilderView(val browser: JBCefBrowser, getURI: () -> String) : JPanel() {
    private val panel: ErrorPanel

    init {
        this.background = Color.white
        this.layout = BoxLayout(this, BoxLayout.PAGE_AXIS)

        panel = ErrorPanel(browser, getURI)
        add(panel)

        addBrowser()
    }

    private fun addBrowser() {
        if (JBCefApp.isSupported() == false) {
            showError("Error: JCEF is required")
            return
        }

        this.add(browser.component)
    }

    fun showError(text: String) {
        printlnError(text)
        panel.setErrorText(text)
    }

    fun showWeb() {
        this.remove(0)
        this.revalidate()
    }
}
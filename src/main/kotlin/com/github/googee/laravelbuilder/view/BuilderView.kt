package com.github.googee.laravelbuilder.view

import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import com.jetbrains.rd.util.printlnError
import java.awt.Color
import javax.swing.*

class BuilderView(browser: JBCefBrowser, getURI: () -> String) : JPanel() {
    private val panel: ErrorPanel

    init {
        this.background = Color.white
        this.layout = BoxLayout(this, BoxLayout.PAGE_AXIS)

        panel = ErrorPanel(browser, getURI)
        this.add(panel)

        if (JBCefApp.isSupported()) {
            this.add(browser.component)
        } else {
            this.showError("Error: JCEF is required")
        }
    }

    fun showError(text: String) {
        printlnError(text)
        panel.setErrorText(text)
    }

    fun showWeb() {
        if (this.components.size == 2) {
            this.remove(0)
        }
        this.revalidate()
    }
}
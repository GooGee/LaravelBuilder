package com.github.googee.laravelbuilder.view

import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import com.jetbrains.rd.util.printlnError
import java.awt.Color
import java.awt.Component
import javax.swing.BoxLayout
import javax.swing.ImageIcon
import javax.swing.JLabel
import javax.swing.JPanel

class BuilderView(val browser: JBCefBrowser) : JPanel(){
    private val label: JLabel

    init {
        this.background = Color.white
        this.layout = BoxLayout(this, BoxLayout.PAGE_AXIS)

        label = JLabel(makeIcon())
        label.foreground = Color.RED
        label.alignmentX = Component.CENTER_ALIGNMENT
        this.add(label)

        addBrowser()
    }

    private fun addBrowser() {
        if (JBCefApp.isSupported() == false) {
            showError("Error: JCEF is required")
            return
        }

        this.add(browser.component)
    }

    private fun makeIcon(): ImageIcon {
        val url = javaClass.getResource("/image/loading.gif")
        return ImageIcon(url)
    }

    fun showError(text: String) {
        printlnError(text)
        label.text = text
    }

    fun showWeb() {
        this.remove(0)
        this.revalidate()
    }
}
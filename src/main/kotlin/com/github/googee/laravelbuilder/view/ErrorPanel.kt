package com.github.googee.laravelbuilder.view

import com.github.googee.laravelbuilder.Constant
import com.intellij.ui.jcef.JBCefBrowser
import com.jetbrains.rd.util.printlnError
import java.awt.Color
import java.awt.Component
import java.awt.Desktop
import java.net.URI
import javax.swing.*


class ErrorPanel(val browser: JBCefBrowser, val getURI: () -> String) : JPanel() {
    private val button: JButton
    private val error: JLabel
    private val label: JLabel
    private val link: JButton

    init {
        this.background = Color.white
        this.layout = BoxLayout(this, BoxLayout.PAGE_AXIS)

        label = JLabel(makeIcon())
        label.text = getURI()
        label.alignmentX = Component.CENTER_ALIGNMENT
        this.add(label)

        error = JLabel()
        error.foreground = Color.RED
        error.alignmentX = Component.CENTER_ALIGNMENT
        this.add(error)

        this.add(Box.createVerticalStrut(11))

        link = JButton("help")
        link.addActionListener() {
            try {
                Desktop.getDesktop().browse(URI(Constant.InstallGuideURI))
            } catch (exception: Exception) {
                exception.message?.let { it1 -> printlnError(it1) }
            }
        }
        this.add(link)

        this.add(Box.createVerticalStrut(11))

        button = JButton("refresh")
        button.addActionListener() {
            error.text = ""
            label.text = getURI()
            browser.loadURL(label.text)
        }
        this.add(button)
    }

    fun setErrorText(text: String) {
        error.text = text
    }

    private fun makeIcon(): ImageIcon {
        val url = javaClass.getResource("/image/loading.gif")
        return ImageIcon(url)
    }

}
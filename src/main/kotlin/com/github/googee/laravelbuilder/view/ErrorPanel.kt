package com.github.googee.laravelbuilder.view

import com.github.googee.laravelbuilder.Constant
import com.jetbrains.rd.util.printlnError
import java.awt.Color
import java.awt.Component
import java.awt.Desktop
import java.net.URI
import javax.swing.*

class ErrorPanel : JPanel() {
    private val label: JLabel
    private val link: JButton

    init {
        this.background = Color.white
        this.layout = BoxLayout(this, BoxLayout.PAGE_AXIS)

        label = JLabel(makeIcon())
        label.foreground = Color.RED
        label.alignmentX = Component.CENTER_ALIGNMENT
        this.add(label)

        link = JButton("help")
        link.addActionListener() {
            try {
                Desktop.getDesktop().browse(URI(Constant.InstallGuideURI))
            } catch (exception: Exception) {
                exception.message?.let { it1 -> printlnError(it1) }
            }
        }
        this.add(link)

    }

    private fun makeIcon(): ImageIcon {
        val url = javaClass.getResource("/image/loading.gif")
        return ImageIcon(url)
    }

}
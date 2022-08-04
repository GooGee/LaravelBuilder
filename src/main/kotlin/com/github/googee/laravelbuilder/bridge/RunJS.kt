package com.github.googee.laravelbuilder.bridge

import org.cef.browser.CefBrowser

class RunJS(private val browser: CefBrowser) {
    fun send(response: Response) {
        val text = response.toString()
        browser.executeJavaScript("window.bridge.call($text)", browser.url, 0)
    }
}
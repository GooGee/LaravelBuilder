package com.github.googee.laravelbuilder.bridge

import com.intellij.ui.jcef.JBCefBrowserBase
import com.intellij.ui.jcef.JBCefJSQuery
import com.intellij.ui.jcef.JBCefJSQuery.Response as JResponse

class CodeFactory(val browser: JBCefBrowserBase, val rm: RequestManager) {

    private val code: String

    init {
        val query = JBCefJSQuery.create(browser)
        query.addHandler { text ->
            JResponse(handle(text).toJSON())
        }
        val function = makeFunction(query)
        code = "window.JavaBridge = {send : $function};"
    }

    private fun handle(text: String): Response {
        var request: Request? = null
        return try {
            request = Request.parse(text)
            println("call Java (${request.action}, ${request.key})")
            rm.handle(request)
        } catch (exception: Exception) {
            if (request != null) {
                Response.error(request.action, request.key, "", exception.message)
            } else {
                Response.error("error", "*", "", exception.message)
            }
        }
    }

    private fun makeFunction(query: JBCefJSQuery): String {
        val onSuccessCallback = "function(response) {window.bridge.send(response)}"
        val onFailureCallback = "function(code, message) {window.bridge.error(code, message)}"
        val code = query.inject("text", onSuccessCallback, onFailureCallback)
        return "function(text) {$code}"
    }

    fun inject() {
        println(code)
        browser.cefBrowser.executeJavaScript(code, browser.cefBrowser.url, 0)
    }
}

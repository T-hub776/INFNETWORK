package com.inf.wifi

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myWebView = WebView(this)
        setContentView(myWebView)

        myWebView.settings.javaScriptEnabled = true

        myWebView.addJavascriptInterface(object {
            @JavascriptInterface
            fun openHotspotSettings() {
                try {
                    val intent = Intent(Intent.ACTION_MAIN).apply {
                        className = "com.android.settings"
                        component = ComponentName("com.android.settings", "com.android.settings.TetherSettings")
                    }
                    startActivity(intent)
                } catch (e: Exception) {
                    val fallbackIntent = Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
                    startActivity(fallbackIntent)
                }
            }
        }, "AndroidInterface")

        myWebView.loadUrl("file:///android_asset/index.html")
    }
}

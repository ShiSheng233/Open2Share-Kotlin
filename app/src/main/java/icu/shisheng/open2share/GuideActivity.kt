package icu.shisheng.open2share


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class GuideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl("https://doc.linesoft.top/shisheng/README.html")
        this.setTitle(R.string.guide)
    }
}

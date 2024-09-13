package com.example.taskwebgridcardview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BrowserActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_browser)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        title = " Мобильный браузер"
        setSupportActionBar(toolbar)

        val webViewWV = findViewById<WebView>(R.id.webViewWV)
        webViewWV.webViewClient = WebViewClient()
        val data = intent.data
        webViewWV.loadUrl(data.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.exit_menu -> {
                finishAffinity()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
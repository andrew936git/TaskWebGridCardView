package com.example.taskwebgridcardview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    private var list = listOf(
        GridViewModal("Яндекс", R.drawable.yandex, "https://ya.ru/"),
        GridViewModal("Google", R.drawable.google, "https://www.google.ru/"),
        GridViewModal("VK", R.drawable.vk, "https://vk.com/feed"),
        GridViewModal("YouTube", R.drawable.youtube, "https://www.youtube.com/"),
        GridViewModal("Stepik", R.drawable.stepik, "https://stepik.org/"),
        GridViewModal("Twitch", R.drawable.twitch, "https://www.twitch.tv/")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        title = " Мобильный браузер"
        setSupportActionBar(toolbar)

        val gridViewGV = findViewById<GridView>(R.id.gridViewGV)
        val adapter = GridViewAdapter(this@MainActivity, list)
        gridViewGV.adapter = adapter

        gridViewGV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(list[position].address)))
        }


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
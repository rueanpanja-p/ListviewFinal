package com.final223.final223

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.hero_list_view)
// 1
        val heroList = Heroes.getHeroesFromFile("heroes.json", this)
// 2
        val listItems = arrayOfNulls<String>(heroList.size)
// 3
        for (i in 0 until heroList.size) {
            val hero = heroList[i]
            listItems[i] = hero.title
        }
// 4
        val adapter = HeroAdapter(this, heroList)
        listView.adapter = adapter
    }
}

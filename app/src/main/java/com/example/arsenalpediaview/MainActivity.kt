package com.example.arsenalpediaview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var RvPlayers: RecyclerView
    private val list = ArrayList<Players>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RvPlayers = findViewById(R.id.rv_players)
        RvPlayers.setHasFixedSize(true)

        list.addAll(getListPlayers())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_page -> {
                val aboutIntent = Intent(this@MainActivity, About::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListPlayers(): ArrayList<Players> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPosition = resources.getStringArray((R.array.data_position))
        val dataCountry = resources.getStringArray((R.array.data_country))
        val dataTeknik = resources.getStringArray((R.array.data_teknik))
        val listPlayers = ArrayList<Players>()
        for (i in dataName.indices) {
            val players = Players(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPosition[i], dataCountry[i], dataTeknik[i])
            listPlayers.add(players)
        }
        return listPlayers
    }

    private fun showRecyclerList() {
        RvPlayers.layoutManager = LinearLayoutManager(this)
        val listPlayers = ListPlayers(list)
        RvPlayers.adapter = listPlayers
    }
}
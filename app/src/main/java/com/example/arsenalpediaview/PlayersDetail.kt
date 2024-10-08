package com.example.arsenalpediaview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlayersDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_detail)

        val imgDetailPlayer = findViewById<ImageView>(R.id.img_detail_players)
        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val tvDetailPosition = findViewById<TextView>(R.id.tv_detail_position)
        val tvDetailCountry = findViewById<TextView>(R.id.tv_detail_country)
        val tvDetailTeknik = findViewById<TextView>(R.id.tv_detail_age)
        val btnShare = findViewById<Button>(R.id.action_share)



        val dataPlayers = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Players>(EXTRA_PERSON,Players::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Players>(EXTRA_PERSON)
        }

        if(dataPlayers != null) {
            imgDetailPlayer.setImageResource(dataPlayers.photo)
            tvDetailName.text = dataPlayers.name
            tvDetailDescription.text = dataPlayers.description
            tvDetailPosition.text = "Position: ${dataPlayers.position}"
            tvDetailCountry.text = "Country: ${dataPlayers.country}"
            tvDetailTeknik.text = dataPlayers.teknik

            btnShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TITLE, "${dataPlayers.name}\n")
                    putExtra(Intent.EXTRA_TEXT, "${dataPlayers.description}")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }
}
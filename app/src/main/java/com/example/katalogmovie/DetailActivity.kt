package com.example.katalogmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvObject: TextView = findViewById(R.id.tv_received)
        val imgObcject: ImageView = findViewById(R.id.img_received)
        val tvDesc: TextView = findViewById(R.id.tv_descReceived)

        val movies = intent.getParcelableExtra(EXTRA_PERSON) as Movie
        val text = movies.name
        val des = movies.description
        tvObject.text = text
        tvDesc.text = des
        Glide.with(this)
            .load(movies.photo)
            .into(imgObcject)
    }
}

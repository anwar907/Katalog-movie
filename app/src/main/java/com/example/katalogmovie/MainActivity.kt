package com.example.katalogmovie

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataDescription: Array<String>
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PERSON, movies[position])
            startActivity(intent)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        dataDescription = resources.getStringArray(R.array.data_description)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            movies.add(movie)
        }
        adapter.movie = movies
    }
}

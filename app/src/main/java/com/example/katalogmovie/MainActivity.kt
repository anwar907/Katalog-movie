package com.example.katalogmovie

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _ ->
            Toast.makeText(this@MainActivity, movies[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare(){
        dataName = resources.getStringArray(R.array.data_name)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem(){
        for (position in dataName.indices){
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataName[position]
            )
            movies.add(movie)
        }
        adapter.movie = movies
    }
}

package com.example.katalogmovie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var movie = arrayListOf<Movie>()
    override fun getView(position: Int, view: View?, parent: ViewGroup): View? {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return  itemView
    }

    override fun getItem(position: Int): Any = movie[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int {
        return movie.size
    }

    private inner class ViewHolder internal constructor(view: View){
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)

        internal fun bind(movie: Movie){
            txtName.text = movie.name
            imgPhoto.setImageResource(movie.photo)
        }
    }
}
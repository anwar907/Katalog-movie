package com.example.katalogmovie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var photo: Int,
    var name: String?,
    var description: String
) : Parcelable
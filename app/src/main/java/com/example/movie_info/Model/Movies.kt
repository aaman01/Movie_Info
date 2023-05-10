package com.example.movie_info.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movies(
   @PrimaryKey val IMDBID: String,
    val Cast: String,
    val Runtime: String,
    val Title: String,
    val Year: String,
   val Genres:String,
   val fav:Boolean
)
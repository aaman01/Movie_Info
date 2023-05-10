package com.example.movie_info.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.movie_info.Database.MovieDatabase
import com.example.movie_info.Model.MovieList
import com.example.movie_info.api.Movieapi

class Repository(
    private  val movieapi: Movieapi,
    private val  movieDatabase: MovieDatabase
) {

    private val movielivedata= MutableLiveData<MovieList>()

    val movies: LiveData<MovieList>
        get() = movielivedata

    suspend fun getmovie(page:String){

        val result=movieapi.getmovies(page)
        if(result?.body()!=null){
            movieDatabase.moviedao().addmovies(result.body()!!.movieList)
            movielivedata.postValue(result.body())

        }
    }

    suspend fun deletemovie(id:String){
        movieDatabase.moviedao().deletemovies(id)
    }

    suspend fun insertfav(id:String,value: Boolean){
        movieDatabase.moviedao().selectfav(id,value)
    }
}


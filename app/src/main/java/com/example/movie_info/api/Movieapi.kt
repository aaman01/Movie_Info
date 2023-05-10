package com.example.movie_info.api


import com.example.movie_info.Model.MovieList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Movieapi {
    @GET("{page}.json")
    suspend fun getmovies(@Path("page") page:String):Response<MovieList>
}
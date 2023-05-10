package com.example.movie_infol.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofithelper {
    private const val BASE_URL="http://task.auditflo.in/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}
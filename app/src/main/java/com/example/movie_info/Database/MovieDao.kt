package com.example.movie_info.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.movie_info.Model.Movies
import retrofit2.http.DELETE
import retrofit2.http.GET


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addmovies(movies:List<Movies>)

    @Query("SELECT * FROM movie")
     fun getmovies():LiveData<List<Movies>>

    @Query("DELETE FROM movie WHERE IMDBID = :ID")
    suspend fun deletemovies(ID: String)

    @Query("UPDATE movie SET  fav = :Value WHERE IMDBID=:ID")
    suspend fun selectfav(ID:String, Value:Boolean)

    @Query("SELECT * FROM movie WHERE fav=1 ")
    fun getfav():LiveData<List<Movies>>
}
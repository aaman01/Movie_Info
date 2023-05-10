package com.example.movie_info.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movie_info.Model.Movies

@Database(entities = [Movies::class], version =  1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun moviedao():MovieDao

    companion object{
        //the momment any updation takes place in instance all threads are made avaialble of it
        @Volatile
        private var INSTANCE:MovieDatabase?=null //private field to hold DB
        //public funtion to acc DB
        fun getDatabase(context: Context):MovieDatabase{
            if (INSTANCE==null){
                //to prevent 2 or more threads to create same obj at same time
                //chane of multiple instance reation may occur
                //we use locking
                synchronized(this){
                    //obj of db created
                    INSTANCE= Room.databaseBuilder(context,MovieDatabase::class.java,
                        "Moviedb").build()
                }

            }
            return INSTANCE!!     // instance can canot be null that why !! is used
        }



    }

}
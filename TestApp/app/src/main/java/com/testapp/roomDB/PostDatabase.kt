package com.testapp.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [PostRoom::class], version = 1)
abstract class PostDatabase: RoomDatabase() {

    abstract fun postDao(): PostDao


    companion object{

         private var instance: PostDatabase? = null

        fun getInstance(context:Context):PostDatabase{

            return  Room.databaseBuilder(
                context = context.applicationContext,
                PostDatabase::class.java,
                "post_db"
            ).build()

        }

    }

}
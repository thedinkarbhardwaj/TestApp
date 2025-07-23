package com.testapp.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {


    @Insert
    fun addPost(post:PostRoom)

    @Query("SELECT * FROM PostTable")
    suspend fun getAllPosts(): List<PostRoom>  // ✅ Get all posts

    @Query("DELETE FROM PostTable")
    suspend fun clearPosts() // (Optional) Clear all posts

}
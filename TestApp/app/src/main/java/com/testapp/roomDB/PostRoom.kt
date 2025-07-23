package com.testapp.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostTable")
data class PostRoom(
    @PrimaryKey
    var id:Int,
    var title:String
)
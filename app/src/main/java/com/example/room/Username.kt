package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class Username (
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "username") val username:String
)
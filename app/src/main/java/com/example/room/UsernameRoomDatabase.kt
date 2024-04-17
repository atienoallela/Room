package com.example.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(Username::class),version = 1,exportSchema = false)
public abstract class UsernameRoomDatabase:RoomDatabase() {
    abstract fun usernameDao():UsernameDao

    companion object {
        @Volatile
        private var INSTANCE:UsernameRoomDatabase? = null

        fun getDatabase(context :Context):UsernameRoomDatabase {
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsernameRoomDatabase::class.java,
                    "username_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
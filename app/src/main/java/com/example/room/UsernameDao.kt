package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsernameDao{
    @Query("SELECT * FROM user_table ORDER BY username ASC")
    fun getAlphabetizedWords(): Flow<List<Username>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(username : Username)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}
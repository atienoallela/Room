package com.example.room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class UsernameRepository(private val usernameDao : UsernameDao) {

    val allnames : Flow<List<Username>> = usernameDao.getAlphabetizedWords()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(username : Username) {
        usernameDao.insert(username)
    }
}
package com.example.retoroom.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines (private val userDao: UserDao) {
    suspend fun save(user: User) = withContext(Dispatchers.IO){
        userDao.save(user.toEntity())
    }

    suspend fun getUsers(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUsersFromDatabase().map { eachUserEntity ->
            eachUserEntity.toUser() })
    }
}
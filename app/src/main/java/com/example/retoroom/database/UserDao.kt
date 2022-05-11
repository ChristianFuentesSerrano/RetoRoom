package com.example.retoroom.database

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USERS")
    fun getUsersFromDatabase(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)
}
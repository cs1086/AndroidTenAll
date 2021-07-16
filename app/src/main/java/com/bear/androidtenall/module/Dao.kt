package com.bear.androidtenall.module

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(user:User)

    @Update
    fun update(user:User)

    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM users WHERE userName LIKE :name")
    fun findUserByName(name:String): List<User>

    @Query("SELECT * FROM users")
    fun findUser(): List<User>

    @Query("DELETE FROM users")
    fun truncateUser()
}
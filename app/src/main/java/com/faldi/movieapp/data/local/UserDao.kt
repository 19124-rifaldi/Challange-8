package com.faldi.movieapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao{
    @Insert
    suspend fun insertUser(user: DataUser) : Long

    @Query("SELECT * FROM DataUser WHERE email = :email AND password LIKE :password")
    suspend fun getUser(email : String, password : String) : DataUser

}
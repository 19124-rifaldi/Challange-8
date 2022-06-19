package com.faldi.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [DataUser::class], version = 1)

abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao
}
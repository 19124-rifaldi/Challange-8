package com.faldi.movieapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataUser(
    @PrimaryKey(autoGenerate = true) var id:Int =0,
    @ColumnInfo(name = "email") var email : String ,
    @ColumnInfo(name = "username") var username : String ,
    @ColumnInfo(name = "password") var password : String
)




package com.faldi.movieapp.repository

import com.faldi.movieapp.data.local.DataUser
import com.faldi.movieapp.data.local.UserDao
import javax.inject.Inject

class AuthRepo @Inject constructor (private val dao: UserDao){
    suspend fun login(email : String,password : String) : DataUser {
        return dao.getUser(email, password)
    }
    suspend fun regist(dataUser: DataUser):Long{
        return dao.insertUser(dataUser)
    }
}
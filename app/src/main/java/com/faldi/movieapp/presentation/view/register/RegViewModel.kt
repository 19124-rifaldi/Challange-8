package com.faldi.movieapp.presentation.view.register

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faldi.movieapp.data.local.DataUser
import com.faldi.movieapp.repository.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegViewModel @Inject constructor (
    private val userRepo: AuthRepo
):ViewModel() {
    private val _register = MutableLiveData<Long>()
    val register : LiveData<Long> get() = _register

    fun registration(
        username:String,
        email:String,
        password:String
    )=viewModelScope.launch{
        val user = DataUser(
            email= email,
            password = password,
            username = username
        )

        try {
            val userData =userRepo.regist(user)
            _register.value=userData
        }catch (e:Exception){
            Log.d("error reg",e.toString())
        }

    }
}
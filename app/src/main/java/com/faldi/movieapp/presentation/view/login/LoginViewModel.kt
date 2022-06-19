package com.faldi.movieapp.presentation.view.login

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faldi.movieapp.data.local.DataUser
import com.faldi.movieapp.repository.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepo: AuthRepo
):ViewModel(){

    private val _state = MutableLiveData<DataUser>()
    val state:LiveData<DataUser>get() = _state

    fun login(email:String,pass : String)=viewModelScope.launch{
        try {
            val data =authRepo.login(email,pass)
            _state.value=data
        }catch (e:Exception){
            Log.d("error log",e.toString())
        }

    }
}
package com.faldi.movieapp.presentation.view.detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faldi.movieapp.data.remote.DetailTest
import com.faldi.movieapp.data.remote.ResultTest
import com.faldi.movieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repo : MovieRepository,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    private var _popState = mutableStateOf(DetailTest())
    val popState: State<DetailTest> = _popState

    val movieId = savedStateHandle.get<Int>("idMovie")


    init {
        movieId?.let { getPopular(it) }
    }

    private fun getPopular(id:Int) = viewModelScope.launch {
        val popular = repo.getDetail(id)
        _popState.value= DetailTest(detail = popular)
        Log.d("test",popular.toString())
    }
}
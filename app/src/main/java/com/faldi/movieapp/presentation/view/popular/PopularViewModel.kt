package com.faldi.movieapp.presentation.view.popular

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faldi.movieapp.data.remote.Result
import com.faldi.movieapp.data.remote.ResultTest
import com.faldi.movieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val popRepo : MovieRepository
) :ViewModel() {
//    val popState : MutableState<List<Result>> = mutableStateOf(listOf())
    private var _popState = mutableStateOf(ResultTest())
    val popState: State<ResultTest> = _popState


    init {
        getPopular()
    }

    private fun getPopular() = viewModelScope.launch {
        val popular = popRepo.getPopular()
        _popState.value= ResultTest(result = popular)
        Log.d("test",popState.toString())
    }

}
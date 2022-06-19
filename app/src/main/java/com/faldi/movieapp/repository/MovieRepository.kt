package com.faldi.movieapp.repository

import com.faldi.movieapp.data.remote.Result
import com.faldi.movieapp.networking.MovieApi
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi :MovieApi) {

    suspend fun getPopular():List<Result>{
        return movieApi.getPopular().results
    }

    suspend fun getDetail(id:Int):Result{
        return movieApi.getDetail(id,"a3694c11f9e2e2c52ca47878bcd70933")
    }
}
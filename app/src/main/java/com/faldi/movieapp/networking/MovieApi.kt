package com.faldi.movieapp.networking

import com.faldi.movieapp.data.remote.GetPopular
import com.faldi.movieapp.data.remote.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular?api_key=a3694c11f9e2e2c52ca47878bcd70933")
    suspend fun getPopular(): GetPopular

    @GET("movie/{movie_id}")
    suspend fun getDetail(
        @Path("movie_id")id:Int,
        @Query("api_key")apiKey:String
    ):Result
}
package com.johndev.shimmereffect.common.dataAccess

import com.johndev.shimmereffect.common.entities.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class HiltServiceImpl @Inject constructor(
    private val retrofit: Retrofit
) : MovieService {

    override suspend fun getMovieNowPlaying(apiKey: String): Response<MovieResponse> {
        val service: MovieService = retrofit.create(MovieService::class.java)
        return service.getMovieNowPlaying(apiKey)
    }


}
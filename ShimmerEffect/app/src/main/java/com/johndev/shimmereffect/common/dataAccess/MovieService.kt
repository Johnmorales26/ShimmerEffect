package com.johndev.shimmereffect.common.dataAccess

import com.johndev.shimmereffect.common.entities.MovieResponse
import com.johndev.shimmereffect.common.utils.Constants.MOVIE_URL
import com.johndev.shimmereffect.common.utils.Constants.NOW_PLAYING_MOVIE_URL
import com.johndev.shimmereffect.common.utils.Constants.QUERY_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(MOVIE_URL + NOW_PLAYING_MOVIE_URL)
    suspend fun getMovieNowPlaying(
        @Query(QUERY_API_KEY) apiKey: String
    ) : Response<MovieResponse>

}
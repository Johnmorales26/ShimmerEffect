package com.johndev.shimmereffect.model

import com.johndev.shimmereffect.common.dataAccess.MovieService
import com.johndev.shimmereffect.common.entities.MovieResponse
import com.johndev.shimmereffect.common.utils.Constants
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val service: MovieService
) {

    suspend fun getListNowPlaying(): MovieResponse? {

        return service.getMovieNowPlaying(Constants.API_KEY).body()
    }

}
package com.johndev.shimmereffect.common.entities

data class MovieResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
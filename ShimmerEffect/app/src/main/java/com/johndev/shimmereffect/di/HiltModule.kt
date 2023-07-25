package com.johndev.shimmereffect.di

import com.johndev.shimmereffect.common.dataAccess.HiltServiceImpl
import com.johndev.shimmereffect.common.dataAccess.MovieService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class HitModule {

    @Singleton
    @Binds
    abstract fun bindHitService(impl: HiltServiceImpl): MovieService

}
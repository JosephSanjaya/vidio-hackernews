package com.vidio.android.interview.data.di

import com.vidio.android.interview.data.repo.TopStoriesDataSource
import com.vidio.android.interview.data.repo.TopStoriesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBind {

    @Binds
    abstract fun bindTopStoriesRepo(
        dataSource: TopStoriesDataSource
    ): TopStoriesRepo

    @Binds
    abstract fun bindDetailStoriesRepo(
        dataSource: TopStoriesDataSource
    ): TopStoriesRepo
}
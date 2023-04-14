package com.vidio.android.interview.domain.di

import com.vidio.android.interview.data.repo.TopStoriesDataSource
import com.vidio.android.interview.data.repo.TopStoriesRepo
import com.vidio.android.interview.domain.usecase.DetailStoriesInteractor
import com.vidio.android.interview.domain.usecase.DetailStoriesUseCase
import com.vidio.android.interview.domain.usecase.TopStoriesInteractor
import com.vidio.android.interview.domain.usecase.TopStoriesListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainBind {

    @Binds
    abstract fun bindTopStoriesRepo(
        interactor: TopStoriesInteractor
    ): TopStoriesListUseCase

    @Binds
    abstract fun bindDetailStoriesRepo(
        interactor: DetailStoriesInteractor
    ): DetailStoriesUseCase
}
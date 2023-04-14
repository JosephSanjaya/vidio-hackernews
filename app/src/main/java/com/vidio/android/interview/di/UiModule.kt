package com.vidio.android.interview.di

import com.vidio.android.interview.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ActivityScoped::class)
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
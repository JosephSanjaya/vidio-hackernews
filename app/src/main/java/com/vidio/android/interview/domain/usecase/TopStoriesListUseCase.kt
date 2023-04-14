package com.vidio.android.interview.domain.usecase

import com.vidio.android.interview.domain.model.News

interface TopStoriesListUseCase {
    suspend operator fun invoke(): List<News>
}
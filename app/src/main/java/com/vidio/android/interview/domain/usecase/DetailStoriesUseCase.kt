package com.vidio.android.interview.domain.usecase

import com.vidio.android.interview.domain.model.News

interface DetailStoriesUseCase {
    suspend operator fun invoke(id: Long): News
}
package com.vidio.android.interview.domain.usecase

import com.vidio.android.interview.data.repo.DetailStoriesRepo
import com.vidio.android.interview.domain.model.News
import javax.inject.Inject

class DetailStoriesInteractor @Inject constructor(
    private val repo: DetailStoriesRepo
) : DetailStoriesUseCase {
    override suspend fun invoke(id: Long): News {
        return News(repo(id))
    }
}
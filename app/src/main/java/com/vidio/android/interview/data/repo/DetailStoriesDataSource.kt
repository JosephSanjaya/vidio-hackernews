package com.vidio.android.interview.data.repo

import com.vidio.android.interview.data.api.NewsApi
import com.vidio.android.interview.data.model.NewsDetailResponse
import javax.inject.Inject

class DetailStoriesDataSource @Inject constructor(
    private val api: NewsApi
): DetailStoriesRepo {
    override suspend fun invoke(id: Long): NewsDetailResponse {
        return api.getDetailStory(id)
    }
}
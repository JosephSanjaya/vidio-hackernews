package com.vidio.android.interview.data.repo

import com.vidio.android.interview.data.api.NewsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.currentCoroutineContext
import javax.inject.Inject

class TopStoriesDataSource @Inject constructor(
    private val api: NewsApi
): TopStoriesRepo {
    override suspend fun invoke(): List<Long> {
        return api.getTopStories()
    }
}
package com.vidio.android.interview.domain.usecase

import com.vidio.android.interview.data.repo.DetailStoriesRepo
import com.vidio.android.interview.data.repo.TopStoriesRepo
import com.vidio.android.interview.domain.model.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.currentCoroutineContext
import javax.inject.Inject

class TopStoriesInteractor @Inject constructor(
    private val topStoriesRepo: TopStoriesRepo,
    private val detailStoriesRepo: DetailStoriesRepo
) : TopStoriesListUseCase {
    override suspend fun invoke(): List<News> {
        return topStoriesRepo().map {
            CoroutineScope(currentCoroutineContext()).async {
                News(detailStoriesRepo(it))
            }.await()
        }
    }
}
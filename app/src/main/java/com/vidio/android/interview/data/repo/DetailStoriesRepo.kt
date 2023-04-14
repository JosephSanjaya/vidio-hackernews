package com.vidio.android.interview.data.repo

import com.vidio.android.interview.data.model.NewsDetailResponse

interface DetailStoriesRepo {
    suspend operator fun invoke(id: Long): NewsDetailResponse
}
package com.vidio.android.interview.data.repo

interface TopStoriesRepo {
    suspend operator fun invoke(): List<Long>
}
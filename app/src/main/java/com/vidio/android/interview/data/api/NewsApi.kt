package com.vidio.android.interview.data.api

import com.vidio.android.interview.data.model.NewsDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {
    @GET("/v0/topstories.json")
    suspend fun getTopStories(): List<Long>

    @GET("/v0/newstories.json")
    suspend fun getNewStories(): List<Long>

    @GET("/v0/beststories.json")
    suspend fun getBestStories(): List<Long>

    @GET("/v0/item/{id}.json")
    suspend fun getDetailStory(@Path("id") id: Long): NewsDetailResponse
}
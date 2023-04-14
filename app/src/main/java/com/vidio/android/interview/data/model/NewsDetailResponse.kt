package com.vidio.android.interview.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsDetailResponse(
    @Json(name = "by")
    val author: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "score")
    val score: Int = 0,
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "type")
    val type: String = "",
    @Json(name = "url")
    val url: String = ""
)
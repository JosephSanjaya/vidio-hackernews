package com.vidio.android.interview.domain.model

import com.vidio.android.interview.data.model.NewsDetailResponse

data class News(val title: String, val subTitle: String, val url: String) {
    constructor(response: NewsDetailResponse): this(
        title = response.title,
        subTitle = response.author,
        url = response.url
    )
}
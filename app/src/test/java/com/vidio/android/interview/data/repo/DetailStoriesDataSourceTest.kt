package com.vidio.android.interview.data.repo

import com.vidio.android.interview.data.api.NewsApi
import com.vidio.android.interview.data.model.NewsDetailResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class DetailStoriesDataSourceTest {

    @Mock
    lateinit var newsApi: NewsApi

    private lateinit var dataSource: DetailStoriesDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        dataSource = DetailStoriesDataSource(newsApi)
    }

    @Test
    fun testInvoke() {
        val id = 123L
        val expected = NewsDetailResponse(id = 123)
        `when`(newsApi.getDetailStory(id)).thenReturn(expected)
        val result = runBlocking {
            dataSource.invoke(id)
        }
        assertEqual(expected, result)
    }
}
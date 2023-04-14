package com.vidio.android.interview

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vidio.android.interview.data.api.NewsApi
import com.vidio.android.interview.data.model.NewsDetailResponse
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.random.Random

class NewsApiTest {
    private lateinit var server: MockWebServer
    private lateinit var api: NewsApi

    @Before
    fun setup() {
        server = MockWebServer()
        api = createApi()
    }

    @Test
    fun `get top stories`() = runBlocking {
        val response = MockResponse().apply { setBody("[33031724]") }

        server.enqueue(response)

        assertEquals(api.getTopStories(), listOf(33031724L))
    }

    @Test
    fun `get detail story`() = runBlocking {
        val response = MockResponse().apply {
            setBody(
                """
            {
              "by" : "ingve",
              "descendants" : 4,
              "id" : 33031724,
              "kids" : [ 33032078, 33032065, 33032092 ],
              "score" : 27,
              "time" : 1664520133,
              "title" : "Intro to the Theory of Programming Languages: full book now freely available",
              "type" : "story",
              "url" : "https://bertrandmeyer.com/2022/09/28/introduction-theory-programming-languages-full-book-now-freely-available/"
            }
        """.trimIndent()
            )
        }

        server.enqueue(response)

        val actual = api.getDetailStory(Random.nextLong())
        val expected = NewsDetailResponse(
            author = "ingve",
            id = 33031724,
            score = 27,
            time = 1664520133,
            title = "Intro to the Theory of Programming Languages: full book now freely available",
            type = "story",
            url = "https://bertrandmeyer.com/2022/09/28/introduction-theory-programming-languages-full-book-now-freely-available/"
        )
        assertEquals(expected, actual)
    }

    private fun createApi(): NewsApi {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder().baseUrl(server.url("/"))
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
            .create(NewsApi::class.java)
    }

}
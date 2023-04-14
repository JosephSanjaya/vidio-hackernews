package com.vidio.android.interview.domain.model

import java.lang.Exception

sealed class State {
    object Loading : State()
    data class Success(val data: List<News>) : State()
    data class Failure(val exception: Exception) : State()
}
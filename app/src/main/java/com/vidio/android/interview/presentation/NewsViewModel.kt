package com.vidio.android.interview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vidio.android.interview.domain.model.State
import com.vidio.android.interview.domain.usecase.TopStoriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val useCase: TopStoriesListUseCase
): ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state get() = _state

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.emit(State.Loading)
            val responses = useCase()
            _state.emit(State.Success(responses))
        }
    }
}
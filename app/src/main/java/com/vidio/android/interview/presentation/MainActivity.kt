package com.vidio.android.interview.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.vidio.android.interview.databinding.ActivityMainBinding
import com.vidio.android.interview.data.api.NewsApi
import com.vidio.android.interview.domain.model.News
import com.vidio.android.interview.domain.model.State
import dagger.android.AndroidInjection
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val LOADING_STATE = 0
        private const val RESULT_STATE = 1
    }

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var newsApi: NewsApi

    private lateinit var adapter: NewsAdapter
    private val viewModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        collectState()
        viewModel.fetch()
    }

    private fun collectState() = lifecycleScope.launch {
        viewModel.state
            .flowWithLifecycle(lifecycle)
            .collect {
                when (it) {
                    is State.Loading -> onLoading()
                    is State.Success -> onSuccess(it.data)
                    is State.Failure -> onError(it.exception)
                }
            }
    }

    private fun onLoading() {
        binding.vfState.displayedChild = LOADING_STATE
    }

    private fun onSuccess(data: List<News>) {
        binding.vfState.displayedChild = RESULT_STATE
        adapter.setNewData(data)
    }

    private fun onError(exception: Exception) {
        // TODO
    }
}

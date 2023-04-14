package com.vidio.android.interview.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vidio.android.interview.databinding.ItemNewsBinding
import com.vidio.android.interview.domain.model.News

class NewsAdapter(
    private val onClick: (String) -> Unit = {}
): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val list = mutableListOf<News>()

    inner class NewsViewHolder(private val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: News) {
            binding.apply {
                title.text = data.title
                subTitle.text = data.subTitle
                onClick(data.url)
            }
        }
    }

    fun setNewData(data: List<News>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context))
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = list[position]
        holder.bind(news)
    }
}
package com.example.ejournal.ui.fragments.news

import com.example.ejournal.base.BaseFragment
import com.example.ejournal.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {
    override fun getViewBinding(): FragmentNewsBinding = FragmentNewsBinding.inflate(layoutInflater)

    override val viewModel: NewsViewModel
        get() = TODO("Not yet implemented")

    override fun initialize() {
        binding.rvNews.adapter = NewsAdapter()
    }
}
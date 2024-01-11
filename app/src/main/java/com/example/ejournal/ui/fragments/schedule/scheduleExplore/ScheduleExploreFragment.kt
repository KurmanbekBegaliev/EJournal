package com.example.ejournal.ui.fragments.schedule.scheduleExplore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejournal.R
import com.example.ejournal.base.BaseFragment
import com.example.ejournal.databinding.FragmentScheduleExploreBinding
import com.example.ejournal.ui.fragments.news.NewsAdapter
import com.example.ejournal.ui.fragments.schedule.adapters.ScheduleExploreAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleExploreFragment : BaseFragment<FragmentScheduleExploreBinding, ScheduleExploreViewModel>() {
    override fun getViewBinding(): FragmentScheduleExploreBinding = FragmentScheduleExploreBinding.inflate(layoutInflater)

    override val viewModel: ScheduleExploreViewModel
        get() = TODO("Not yet implemented")

    private lateinit var adapter: ScheduleExploreAdapter

    override fun initialize() {
        adapter = ScheduleExploreAdapter()
        binding.rvSchedule.adapter = adapter
    }

}
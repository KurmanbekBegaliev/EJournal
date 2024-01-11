package com.example.ejournal.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ejournal.R
import com.example.ejournal.base.BaseFragment
import com.example.ejournal.databinding.FragmentProfileBinding
import com.example.ejournal.tools.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override fun getViewBinding(): FragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater)

    override val viewModel: ProfileViewModel by viewModels()

    override fun initialize() {
        binding.imgUserAvatar.setImage("https://studentapi2002.pythonanywhere.com/media/photo/2023/12/22/4.png")
    }

}
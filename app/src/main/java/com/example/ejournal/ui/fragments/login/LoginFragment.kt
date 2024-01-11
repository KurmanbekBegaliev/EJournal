package com.example.ejournal.ui.fragments.login

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.ejournal.R
import com.example.ejournal.base.BaseFragment
import com.example.ejournal.data.local.PreferencesHelper
import com.example.ejournal.data.models.TeacherItem
import com.example.ejournal.data.models.Teachers
import com.example.ejournal.databinding.FragmentLoginBinding
import com.example.ejournal.tools.UiState
import com.example.ejournal.tools.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override fun getViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)

    override val viewModel: LoginViewModel by viewModels()

    private val preferences: PreferencesHelper by lazy {
        PreferencesHelper(requireContext())
    }

    override fun initialize() {

        if (preferences.isLoginSuccess) {
            findNavController().navigate(R.id.mainFragment)
        }

        binding.btnLogin.setOnClickListener {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.responseState.collect{
                        when (it) {
                            is UiState.Empty -> {}
                            is UiState.Error -> {
                                showToast(it.msg)
                            }
                            is UiState.Loading -> {}
                            is UiState.Success -> {
                                it.data?.let { it1 -> checkLogin(it1 as ArrayList<TeacherItem>) }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun checkLogin(teachers: ArrayList<TeacherItem>) {

        val login = binding.edtUsername.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        for(i in teachers) {
            if (i.login == login && i.password == password) {
                showToast("Правильно")
                preferences.isLoginSuccess = true
                findNavController().navigate(R.id.mainFragment)
            } else {
                showToast("Вы ввели неправильный логин или пароль.")
            }
        }
    }

}
package com.example.ejournal.ui.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejournal.data.models.Teachers
import com.example.ejournal.data.repositories.Repository
import com.example.ejournal.tools.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    init {
        getTeachers()
    }

    private var _responseState = MutableStateFlow<UiState<Teachers>>(UiState.Empty())
    val responseState = _responseState.asStateFlow()

    private fun getTeachers() = viewModelScope.launch {
        repository.getTeachers().collect {
            _responseState.value = it
        }
    }
}
package com.akash.userdataapplication.ui.presentation.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.akash.userdataapplication.data.repository.UserDataRepositoryImpl
import com.akash.userdataapplication.domain.repository.UserDataRepository
import kotlinx.coroutines.launch

class UserDataViewModel(
    val repository: UserDataRepositoryImpl
) : ViewModel() {

    private val _state = mutableStateOf(UserDataListState(emptyList()))
    val state : State<UserDataListState> = _state

    init {
        viewModelScope.launch {
            //val listUsers = repository.getUserData()
            val datauser = repository.getUserData()
            _state.value = state.value.copy(
                UserDataList = datauser
            )
        }
    }

    class Factory(private val repository: UserDataRepositoryImpl) : ViewModelProvider.Factory{


        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserDataViewModel(repository) as T
        }

    }

}
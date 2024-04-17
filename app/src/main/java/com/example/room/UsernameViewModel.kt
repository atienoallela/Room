package com.example.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class UsernameViewModel(private val repository : UsernameRepository):ViewModel() {
    val allnames : LiveData<List<Username>> = repository.allnames.asLiveData()

    fun insert(username : Username) = viewModelScope.launch{
        repository.insert(username)
    }
}

class UsernameViewModelFactory(private val repository : UsernameRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass : Class<T>) :T{
        if (modelClass.isAssignableFrom(UsernameViewModel::class.java)){
            @Suppress("UNCHECKED CAST")
            return UsernameViewModel(repository) as T
        }
        throw IllegalArgumentException("Uknown model")
    }
}
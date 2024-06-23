package com.example.todoapp.ui.actionitem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.repositories.ActionRepository

class ActionItemViewModelFactory(
    private val repository : ActionRepository
)  : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return ActionItemViewModel(repository) as T
    }
}
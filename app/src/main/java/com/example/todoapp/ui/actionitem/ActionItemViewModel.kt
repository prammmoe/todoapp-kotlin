package com.example.todoapp.ui.actionitem

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.db.entities.ActionItem
import com.example.todoapp.repositories.ActionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActionItemViewModel(
    private val repository: ActionRepository
) : ViewModel() {
    fun insert(item: ActionItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ActionItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllActionItems() = repository.getAllActionItems()
}
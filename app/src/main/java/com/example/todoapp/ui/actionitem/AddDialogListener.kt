package com.example.todoapp.ui.actionitem

import com.example.todoapp.data.db.entities.ActionItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ActionItem)
}
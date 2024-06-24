package com.example.todoapp.ui.actionitem

import com.example.todoapp.data.db.entities.ActionItem

interface EditDialogListener {
    fun onEditButtonClicked(item: ActionItem)
}

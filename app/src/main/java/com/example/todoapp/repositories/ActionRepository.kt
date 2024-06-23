package com.example.todoapp.repositories

import com.example.todoapp.data.db.ActionDatabase
import com.example.todoapp.data.db.entities.ActionItem

class ActionRepository(
    private val db:ActionDatabase
) {
    suspend fun insert(item: ActionItem) = db.getActionDao().insert(item)
    suspend fun delete(item: ActionItem) = db.getActionDao().delete(item)

    fun getAllActionItems() = db.getActionDao().getAllActionItems()
}
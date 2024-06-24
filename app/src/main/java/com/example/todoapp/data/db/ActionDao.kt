package com.example.todoapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.todoapp.data.db.entities.ActionItem

@Dao
interface ActionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ActionItem)

    @Delete
    suspend fun delete(item: ActionItem)

    @Update
    suspend fun update(item: ActionItem)

    @Query("SELECT * FROM action_items")
    fun getAllActionItems(): LiveData<List<ActionItem>>
}
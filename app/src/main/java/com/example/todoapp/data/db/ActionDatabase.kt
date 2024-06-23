package com.example.todoapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.db.entities.ActionItem

@Database(
    entities = [ActionItem::class],
    version = 1,
    exportSchema = false
)
abstract class ActionDatabase : RoomDatabase() {

    abstract fun getActionDao(): ActionDao

    companion object {
        @Volatile
        private var instance: ActionDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): ActionDatabase {
            return instance ?: synchronized(LOCK) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ActionDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ActionDatabase::class.java,
                "ActionItemDB.db"
            ).build()
        }
    }
}

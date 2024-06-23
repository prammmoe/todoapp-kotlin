package com.example.todoapp

import android.app.Application
import com.example.todoapp.data.db.ActionDatabase
import com.example.todoapp.repositories.ActionRepository
import com.example.todoapp.ui.actionitem.ActionItemViewModelFactory

import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class TodoListApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@TodoListApplication))
        bind() from singleton { ActionDatabase(instance()) }
        bind() from singleton {
            ActionRepository(
                instance()
            )
        }
        bind() from provider {
            ActionItemViewModelFactory(
                instance()
            )
        }
    }
}
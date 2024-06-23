package com.example.todoapp.ui.actionitem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.data.db.entities.ActionItem
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.ui.adapter.ActionItemAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    private lateinit var binding: ActivityMainBinding
    override val kodein by kodein()
    private val factory: ActionItemViewModelFactory by instance()

    private lateinit var viewModel: ActionItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory)[ActionItemViewModel::class.java]

        val adapter = ActionItemAdapter(listOf(), viewModel)

        binding.rvActionItems.layoutManager = LinearLayoutManager(this)
        binding.rvActionItems.adapter = adapter

        viewModel.getAllActionItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            AddActionItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ActionItem) {
                        viewModel.insert(item)
                    }
                }).show()
        }
    }
}

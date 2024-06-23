package com.example.todoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.db.entities.ActionItem
import com.example.todoapp.databinding.ActionItemBinding
import com.example.todoapp.ui.actionitem.ActionItemViewModel

class ActionItemAdapter(
    var items: List<ActionItem>,
    private val viewModel: ActionItemViewModel
) : RecyclerView.Adapter<ActionItemAdapter.ActionItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionItemViewHolder {
        val binding = ActionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActionItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ActionItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    inner class ActionItemViewHolder(private val binding: ActionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(actionItem: ActionItem) {
            binding.tvName.text = actionItem.name
            binding.statusCheckBox.isChecked = actionItem.status

            binding.ivDelete.setOnClickListener {
                viewModel.delete(actionItem)
            }

            binding.statusCheckBox.setOnCheckedChangeListener { _, isChecked ->
                actionItem.status = isChecked
                viewModel.insert(actionItem)
            }
        }
    }
}

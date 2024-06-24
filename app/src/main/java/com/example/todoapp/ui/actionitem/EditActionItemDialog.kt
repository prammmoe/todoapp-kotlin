package com.example.todoapp.ui.actionitem

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.todoapp.data.db.entities.ActionItem
import com.example.todoapp.databinding.DialogAddActionItemBinding

class EditActionItemDialog(
    context: Context,
    private var actionItem: ActionItem,
    private var editDialogListener: EditDialogListener
) : AppCompatDialog(context) {

    private lateinit var binding: DialogAddActionItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddActionItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etName.setText(actionItem.name)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            actionItem.name = name
            editDialogListener.onEditButtonClicked(actionItem)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}

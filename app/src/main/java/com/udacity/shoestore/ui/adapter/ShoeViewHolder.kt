package com.udacity.shoestore.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.data.models.Shoe
import com.udacity.shoestore.databinding.ItemShoeBinding

class ShoeViewHolder(private val binding: ItemShoeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Shoe) {
        binding.textviewShoeName.text = item.name.capitalize()
        binding.textviewShoeCompany.text = item.company
        binding.textviewShoeSize.text = "Size: ${item.size}"
        binding.textviewShoeDescription.text = item.description
    }
}
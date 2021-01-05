package com.udacity.shoestore.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.udacity.shoestore.data.models.Shoe
import com.udacity.shoestore.databinding.ItemShoeBinding

class ShoeAdapter :
    ListAdapter<Shoe, ShoeViewHolder>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShoeViewHolder(
            ItemShoeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Shoe>() {
            override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean =
                oldItem.name == newItem.name && oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean =
                oldItem == newItem
        }
    }
}

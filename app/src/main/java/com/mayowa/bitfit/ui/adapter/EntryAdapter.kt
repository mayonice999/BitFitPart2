package com.mayowa.bitfit.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mayowa.bitfit.databinding.ItemEntryBinding
import com.mayowa.bitfit.data.EntryEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EntryAdapter : ListAdapter<EntryEntity, EntryAdapter.VH>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<EntryEntity>() {
            override fun areItemsTheSame(oldItem: EntryEntity, newItem: EntryEntity) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: EntryEntity, newItem: EntryEntity) = oldItem == newItem
        }
        private val timeFmt = SimpleDateFormat("MMM d, h:mm a", Locale.getDefault())
    }

    inner class VH(val binding: ItemEntryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inf = LayoutInflater.from(parent.context)
        val binding = ItemEntryBinding.inflate(inf, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.binding.tvAmount.text = "${item.amountMl} mL"
        holder.binding.tvTime.text = timeFmt.format(Date(item.timestamp))
    }
}

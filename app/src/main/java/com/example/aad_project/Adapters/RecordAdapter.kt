package com.example.aad_project.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aad_project.Model.Record

import com.example.aad_project.databinding.RecordRecyclerViewItemBinding

class RecordsAdapter : RecyclerView.Adapter<RecordsAdapter.RecordViewHolder>() {

    var records = emptyList<Record>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder =
        RecordViewHolder(
            RecordRecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(records[position])
    }

    override fun getItemCount(): Int = records.size

    fun records(records: List<Record>) {
        this.records = records

        notifyDataSetChanged()
    }

    class RecordViewHolder(private val binding: RecordRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(record: Record) {
            binding.record = record
        }
    }

}
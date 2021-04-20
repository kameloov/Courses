package com.touta.courses.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.touta.courses.R

class CallBack : DiffUtil.ItemCallback<Int>() {
    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return  oldItem == newItem
    }
}

class ErrorAdapter : ListAdapter<Int,ErrorAdapter.ErrorHolder>(CallBack()){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ErrorHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_error,parent,false)
            return ErrorHolder(view)
    }

    override fun onBindViewHolder(holder: ErrorHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ErrorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var txtError: TextView = itemView.findViewById(R.id.txtError)
        fun bind(item: Int){
            txtError.setText(item)
        }
    }
}
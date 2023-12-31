package com.devocean.greendev.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devocean.greendev.R
import com.devocean.greendev.model.RecordData

class RecordAdapter(private val items: ArrayList<RecordData>): RecyclerView.Adapter<RecordAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.record_item_layout, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.campaign_title.text = item.campaign_title
        holder.date.text = item.date
        holder.message.text = item.message
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): Int {
        return items[position].postId
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        val campaign_title: TextView = view.findViewById(R.id.campaign_title)
        val message: TextView = view.findViewById(R.id.message)
        val date: TextView = view.findViewById(R.id.date)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }
}
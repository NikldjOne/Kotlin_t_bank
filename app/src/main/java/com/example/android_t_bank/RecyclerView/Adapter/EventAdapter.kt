package com.example.android_t_bank.RecyclerView.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_t_bank.R
import com.example.android_t_bank.RecyclerView.Event

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    var data: List<Event> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_item, parent, false)
        return EventViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        data[position].let {
            holder.eventImage.setImageResource(it.imageRestId)
            holder.eventName.text = it.name
            holder.eventTime.text = it.time
        }
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventImage: ImageView = itemView.findViewById(R.id.eventImage)
        val eventName: TextView = itemView.findViewById(R.id.description)
        val eventTime: TextView = itemView.findViewById(R.id.timeText)
    }
}
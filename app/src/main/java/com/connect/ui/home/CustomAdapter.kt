package com.connect.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.connect.R
import kotlinx.android.synthetic.main.card_view.view.*
import java.util.*

class CustomAdapter(
        private val dates: List<DateObject>
): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val items: MutableList<CardView>

    init {
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v =  LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return dates.size
    }

    // bind data to elements
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.tvTitle.text = dates[position].title
        items.add(holder.card)
    }

    inner class ViewHolder
    internal constructor(
            itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.tvTitle
        val card: CardView = itemView.card
    }
}
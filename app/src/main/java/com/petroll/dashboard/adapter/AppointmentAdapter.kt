package com.petroll.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R

class AppointmentAdapter(private val mList: List<String>, private val context: Context) :
    RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppointmentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_appointment, parent, false)
        return AppointmentAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppointmentAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val auctionTitle = itemView.findViewById<TextView>(R.id.tv_auction_end)
        val auctionDate = itemView.findViewById<TextView>(R.id.tv_time_date)
        val bidTitle = itemView.findViewById<TextView>(R.id.tv_current_bid_title)
    }
}
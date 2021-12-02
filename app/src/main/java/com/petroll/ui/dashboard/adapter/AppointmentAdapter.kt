package com.petroll.ui.dashboard.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R
import com.petroll.ui.dashboard.service.AppoitmentDetailActivity

class AppointmentAdapter(private val mList: List<String>, val context: Activity) :
    RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_appointment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            val intent = Intent(context, AppoitmentDetailActivity::class.java)
            context.startActivity(intent)
        }
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
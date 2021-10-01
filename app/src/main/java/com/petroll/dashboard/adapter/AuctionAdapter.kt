package com.petroll.dashboard.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R
import com.petroll.dashboard.market.marketpackage.buy_detail.AuctionDetailActivity

class AuctionAdapter(private val mList: List<String>, private val context: Context) :
    RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_auction, parent, false)
        return AppointmentAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppointmentAdapter.ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            val intent = Intent(context, AuctionDetailActivity::class.java)
            context.startActivity(intent)
        }

        if (mList[position] == "ongoing") {
            holder.auctionTitle.text = context.resources.getString(R.string.auction_ends)
            holder.auctionDate.text = "4h : 10m"
            holder.bidTitle.text = context.resources.getString(R.string.current_bid)
        } else {
            holder.auctionTitle.text = context.resources.getString(R.string.auction_ends) + " on"
            holder.auctionDate.text = "09-09-2021"
            holder.bidTitle.text = context.resources.getString(R.string.final_price)
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
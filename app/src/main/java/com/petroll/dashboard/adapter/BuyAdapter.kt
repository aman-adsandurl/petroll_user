package com.petroll.dashboard.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R
import com.petroll.dashboard.market.marketpackage.buy_detail.BuyDetailActivity

class BuyAdapter(val context: Activity): RecyclerView.Adapter<BuyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_buy, parent, false)

        return BuyAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuyAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, BuyDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return 6
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }
}
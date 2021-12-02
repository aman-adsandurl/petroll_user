package com.petroll.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R

class SoldAdapter : RecyclerView.Adapter<SoldAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val rlSold = itemView.findViewById<RelativeLayout>(R.id.rl_sold)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_sold, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position > 4) {
            holder.rlSold.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

}
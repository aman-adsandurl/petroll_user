package com.petroll.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R

class WishlistAdapter():
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishlistAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_wishlist, parent, false)

        return WishlistAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishlistAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 5
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val ivNotificationRead = itemView.findViewById<RelativeLayout>(R.id.rl_notification_read)
//        val tvNotification = itemView.findViewById<TextView>(R.id.tv_notification)
    }
}
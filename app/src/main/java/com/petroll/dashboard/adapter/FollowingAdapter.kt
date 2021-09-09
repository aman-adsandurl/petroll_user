package com.petroll.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R

class FollowingAdapter():
    RecyclerView.Adapter<FollowingAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_following, parent, false)
        return FollowingAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowingAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val ivNotificationRead = itemView.findViewById<RelativeLayout>(R.id.rl_notification_read)
//        val tvNotification = itemView.findViewById<TextView>(R.id.tv_notification)
    }
}
package com.petroll.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R

class FollowingAdapter(val isBlock: Boolean, val context: Context):
    RecyclerView.Adapter<FollowingAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_following, parent, false)
        return FollowingAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowingAdapter.ViewHolder, position: Int) {
            if (!isBlock) {
                holder.tvHeader.text = context.resources.getString(R.string.unfollow)
            } else {
                holder.tvHeader.text = context.resources.getString(R.string.unblock)
            }
    }

    override fun getItemCount(): Int {
        return 4
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvHeader = itemView.findViewById<TextView>(R.id.tv_unfollow)
//        val ivNotificationRead = itemView.findViewById<RelativeLayout>(R.id.rl_notification_read)
//        val tvNotification = itemView.findViewById<TextView>(R.id.tv_notification)
    }
}
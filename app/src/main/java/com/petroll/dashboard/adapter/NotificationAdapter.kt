package com.petroll.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R

class NotificationAdapter(private val mList: List<String>):
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_notification, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationAdapter.ViewHolder, position: Int) {
        holder.tvNotification.text = mList[position]

        if (position % 2 == 0) {
            holder.ivNotificationRead.visibility = View.INVISIBLE
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivNotificationRead = itemView.findViewById<RelativeLayout>(R.id.rl_notification_read)
        val tvNotification = itemView.findViewById<TextView>(R.id.tv_notification)
    }
}
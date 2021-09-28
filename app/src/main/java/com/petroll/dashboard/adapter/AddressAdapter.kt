package com.petroll.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R
import com.petroll.utils.IconCircleLayout

class AddressAdapter(val context: Context): RecyclerView.Adapter<AddressAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_new_address, parent, false)

        return AddressAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivCheck = itemView.findViewById<ImageView>(R.id.iv_check)
        val ivUnCheck = itemView.findViewById<ImageView>(R.id.iv_uncheck)
        val rlCheck = itemView.findViewById<RelativeLayout>(R.id.rl_check)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rlCheck.setOnClickListener {
            if (holder.ivCheck.visibility == View.VISIBLE) {
                holder.ivCheck.visibility = View.GONE
                holder.ivUnCheck.visibility = View.VISIBLE
            } else {
                holder.ivUnCheck.visibility = View.GONE
                holder.ivCheck.visibility = View.VISIBLE
            }
        }
    }
}
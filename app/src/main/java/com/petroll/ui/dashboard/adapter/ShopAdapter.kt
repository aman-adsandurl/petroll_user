package com.petroll.ui.dashboard.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R
import com.petroll.ui.dashboard.market.marketpackage.ShopActivity
import com.petroll.ui.dashboard.market.marketpackage.detail.ShopDetail

class ShopAdapter(val context: ShopActivity) : RecyclerView.Adapter<ShopAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_shops, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ShopDetail::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return 6
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }
}
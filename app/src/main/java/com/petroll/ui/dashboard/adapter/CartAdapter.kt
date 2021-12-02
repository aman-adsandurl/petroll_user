package com.petroll.ui.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R
import com.petroll.utils.IconCircleLayout

class CartAdapter(val context: Context): RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_cart, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val iclFav = itemView.findViewById<IconCircleLayout>(R.id.icl_fav)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.iclFav.setImageResource(R.drawable.ic_wishlist, AppCompatResources.getColorStateList(context,R.color.skip_circle_color))
    }
}
package com.petroll.ui.dashboard.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R
import com.petroll.ui.dashboard.market.marketpackage.detail.ProductDetailActivity
import com.petroll.ui.dashboard.market.marketpackage.detail.ProductListingActivity

class ProductAdapter(val context: ProductListingActivity): RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppointmentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_product, parent, false)
        return AppointmentAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppointmentAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return 10
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }

}
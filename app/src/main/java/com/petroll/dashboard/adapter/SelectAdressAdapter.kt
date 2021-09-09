package com.petroll.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petroll.R

class SelectAdressAdapter() :
    RecyclerView.Adapter<SelectAdressAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectAdressAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_address, parent, false)

        return SelectAdressAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectAdressAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 2
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }
}
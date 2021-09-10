package com.petroll.Navigation.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.dashboard.DashboardActivity
import com.petroll.dashboard.adapter.AppointmentAdapter
import com.petroll.dashboard.adapter.AuctionAdapter
import com.petroll.dashboard.adapter.OrderAdapter
import com.petroll.databinding.FragmentAuctionBinding
import com.petroll.databinding.FragmentOrderBinding

class OrdersFragment : Fragment() {

    lateinit var binding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(layoutInflater)
        setUpBackLayout()
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpBackLayout() {
        binding.iconLayout.iclCheck.setImageResource(R.drawable.ic_wishlist, AppCompatResources.getColorStateList(requireContext(),R.color.skip_circle_color))
        binding.iconLayout.iclFav.setImageResource(R.drawable.ic_cart, AppCompatResources.getColorStateList(requireContext(),R.color.skip_circle_color))

        binding.iconLayout.iclWish.visibility = View.GONE

        binding.back.tvBack.text = resources.getText(R.string.my_orders)
        binding.back.backLayout.setOnClickListener {
            (activity as DashboardActivity).onHome()
        }
    }

    private fun setUpRecyclerView() {
        binding.rvOrder.layoutManager = LinearLayoutManager(context)
        val adapter = OrderAdapter()
        binding.rvOrder.adapter = adapter
    }
}
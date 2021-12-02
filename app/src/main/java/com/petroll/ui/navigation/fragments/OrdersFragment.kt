package com.petroll.ui.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.FragmentOrderBinding
import com.petroll.ui.dashboard.adapter.OrderAdapter
import com.petroll.utils.BaseActivity

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
        binding.iconLayout.iclCheck.setImageResource(
            R.drawable.ic_wishlist,
            AppCompatResources.getColorStateList(requireContext(), R.color.skip_circle_color)
        )
        binding.iconLayout.iclFav.setImageResource(
            R.drawable.ic_cart,
            AppCompatResources.getColorStateList(requireContext(), R.color.skip_circle_color)
        )

        binding.iconLayout.iclWish.visibility = View.GONE

        binding.back.tvBack.text = resources.getText(R.string.my_orders)
        binding.back.backLayout.setOnClickListener {
            (activity as BaseActivity).onHome()
        }
    }

    private fun setUpRecyclerView() {
        binding.rvOrder.layoutManager = LinearLayoutManager(context)
        val adapter = OrderAdapter()
        binding.rvOrder.adapter = adapter
    }
}
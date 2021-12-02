package com.petroll.ui.cart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.databinding.FragmentCartBinding
import com.petroll.ui.dashboard.adapter.CartAdapter

class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CartAdapter(requireContext())
        binding.rvCart.adapter = adapter
    }


}
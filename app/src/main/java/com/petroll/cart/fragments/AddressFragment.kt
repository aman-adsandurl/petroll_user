package com.petroll.cart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.dashboard.adapter.AddressAdapter
import com.petroll.dashboard.adapter.CartAdapter
import com.petroll.databinding.FragmentAddressBinding
import com.petroll.databinding.FragmentCartBinding
import com.petroll.databinding.FragmentFollowingBinding

class AddressFragment: Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater)
        setUpRecyclerView()
//        (activity as BaseActivity).hideBottomBar(resources.getString(R.string.add_new_address))
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        val adapter = AddressAdapter(requireContext())
        binding.rvCart.adapter = adapter
    }

}
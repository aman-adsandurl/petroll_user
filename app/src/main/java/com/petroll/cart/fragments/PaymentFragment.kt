package com.petroll.cart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.petroll.databinding.FragmentFollowingBinding
import com.petroll.databinding.FragmentPaymentBinding

class PaymentFragment: Fragment() {

    lateinit var binding: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentBinding.inflate(layoutInflater)
//        setUpRecyclerView()
//        setUpBackLayout()
//        (activity as BaseActivity).hideBottomBar(resources.getString(R.string.add_new_address))
        return binding.root
    }
}
package com.petroll.ui.cart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.FragmentAddressBinding
import com.petroll.ui.cart.CartActivity
import com.petroll.ui.dashboard.adapter.AddressAdapter
import com.petroll.utils.BaseActivity

class AddressFragment: Fragment() {

    lateinit var binding: FragmentAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressBinding.inflate(layoutInflater)
        binding.tvAddAddress.setOnClickListener {
            if (binding.rvCart.visibility == View.VISIBLE) {
                binding.newAddressForm.llAddressForm.visibility = View.VISIBLE
                binding.rvCart.visibility = View.GONE

                (activity as BaseActivity).setBottomBarText(getString(R.string.add_new_address))

                (activity as BaseActivity).baseBind.rlNext.setOnClickListener {
                    binding.newAddressForm.llAddressForm.visibility = View.GONE
                    binding.rvCart.visibility = View.VISIBLE
                    (activity as BaseActivity).setBottomBarText(getString(R.string.checkout))
                    (activity as CartActivity).setNextClick()
                }

            }
        }
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        val adapter = AddressAdapter(requireContext())
        binding.rvCart.adapter = adapter
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            initiate()
        }
    }

    public fun initiate() {
       binding.rvCart.visibility = View.VISIBLE
       binding.newAddressForm.llAddressForm.visibility = View.GONE
   }
}
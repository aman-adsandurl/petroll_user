package com.petroll.ui.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.FragmentChatBinding
import com.petroll.ui.dashboard.adapter.ChatAdapter
import com.petroll.utils.BaseActivity

class ChatFragment : Fragment() {

    lateinit var binding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)
        setUpRecyclerView()
        setUpBackLayout()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvChat.layoutManager = LinearLayoutManager(context)
        val adapter = ChatAdapter()
        binding.rvChat.adapter = adapter
    }

    private fun setUpBackLayout() {

        binding.back.tvBack.text = resources.getText(R.string.chat)
        binding.back.backLayout.setOnClickListener {
            (activity as BaseActivity).onHome()
        }
    }
}
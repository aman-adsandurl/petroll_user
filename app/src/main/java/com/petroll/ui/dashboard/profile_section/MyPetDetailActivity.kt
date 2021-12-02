package com.petroll.ui.dashboard.profile_section

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityMatingsBinding
import com.petroll.ui.dashboard.adapter.MatingAdapter
import com.petroll.utils.BaseActivity

class MyPetDetailActivity: BaseActivity() {

    lateinit var binding: ActivityMatingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBackLayout()
        hideContent()
        setUpRecyclerView()
        setUpFragmentsBottomBar()
        // todo to shift it to base activity
        setUpBottomClickedView(false)
    }

    private fun setUpRecyclerView() {
        binding.rvPost.layoutManager = LinearLayoutManager(this)
        val adapter = MatingAdapter(listOf("a", "b","a", "b","a", "b"),this)
        binding.rvPost.adapter = adapter
    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.mating)
        binding.back.backLayout.setOnClickListener {
            finish()
        }
    }
}
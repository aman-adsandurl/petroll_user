package com.petroll.ui.dashboard.community.services

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.petroll.R
import com.petroll.databinding.ActivityAdoptionBinding
import com.petroll.ui.dashboard.adapter.AdoptionAdapter
import com.petroll.utils.BaseActivity

class AdoptionActivity: BaseActivity() {

    lateinit var binding: ActivityAdoptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdoptionBinding.inflate(layoutInflater)
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
            val adapter = AdoptionAdapter(listOf("a", "b","a", "b","a", "b"), this)
            binding.rvPost.adapter = adapter
    }


    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.adoption)
        binding.back.backLayout.setOnClickListener {
            finish()
        }

        onQuickAccessClick {
            Toast.makeText(this, "Quick Access", Toast.LENGTH_SHORT).show()
            //TODO:
        }
    }
}
package com.petroll.dashboard.fragments

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.petroll.R
import com.petroll.dashboard.DashboardActivity
import com.petroll.databinding.FragmentProfileDashboardBinding

class ProfileDashboardFragment : Fragment() {

    lateinit var binding: FragmentProfileDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileDashboardBinding.inflate(layoutInflater)
        setUpBackLayout()
        setUpCircleLayout()
        return binding.root
    }

    private fun setUpCircleLayout() {
        binding.petLayout.setSmallCircle()
        binding.matingLayout.setSmallCircle()
        binding.pregnancyLayout.setSmallCircle()
        binding.vaccineLayout.setSmallCircle()

        binding.petLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(requireContext(),R.color.owner_c))
        binding.matingLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(requireContext(),R.color.pink4))
        binding.pregnancyLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(requireContext(),R.color.blue3))
        binding.vaccineLayout.setBackgroundColorTint(AppCompatResources.getColorStateList(requireContext(),R.color.ligh_greyish))


        binding.petLayout.setImageText(resources.getString(R.string.my_pet), R.drawable.ic_pet)
        binding.matingLayout.setImageText(resources.getString(R.string.mating), R.drawable.ic_mating)
        binding.pregnancyLayout.setImageText(resources.getString(R.string.preganncy), R.drawable.ic_pregnancy)
        binding.vaccineLayout.setImageText(resources.getString(R.string.vaccine), R.drawable.ic_vaccine)

        binding.petLayout.setTextColorLayout(AppCompatResources.getColorStateList(requireContext(), R.color.black))
        binding.matingLayout.setTextColorLayout(AppCompatResources.getColorStateList(requireContext(),R.color.black))
        binding.pregnancyLayout.setTextColorLayout(AppCompatResources.getColorStateList(requireContext(),R.color.black))
        binding.vaccineLayout.setTextColorLayout(AppCompatResources.getColorStateList(requireContext(),R.color.black))

        binding.petLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14))
        binding.matingLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )
        binding.pregnancyLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

        binding.vaccineLayout.setSmallTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            resources.getDimension(R.dimen.dimen14)
        )

    }

    private fun setUpBackLayout() {
        binding.back.tvBack.text = resources.getText(R.string.profile)
        binding.back.backLayout.setOnClickListener {
            (activity as DashboardActivity).onHome()
        }
    }
}
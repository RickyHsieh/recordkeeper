package com.purplestudio.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.purplestudio.recordkeeper.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.containerBiggestClimb.setOnClickListener {
            // Navigate to 5km activity
            launchCyclingRecordScreen("Biggest Climb")
        }
        binding.containerBestAverageSpeed.setOnClickListener {
            launchCyclingRecordScreen("Best Average Speed")
        }
        binding.containerLongestRide.setOnClickListener {
            launchCyclingRecordScreen("Longest Ride")
        }
    }

    private fun launchCyclingRecordScreen(type: String) {
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra(
            "Type", type
        )
        startActivity(intent)
    }
}
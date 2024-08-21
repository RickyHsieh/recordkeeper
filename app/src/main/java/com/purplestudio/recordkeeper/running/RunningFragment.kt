package com.purplestudio.recordkeeper.running

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.purplestudio.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun displayRecords() {
        requireContext().getSharedPreferences("running", MODE_PRIVATE).apply {
            binding.textView5km.text = getString("5km record", null)
            binding.textView5kmDate.text = getString("5km date", null)
            binding.textView10kmDate.text = getString("10km date", null)
            binding.textView10km.text = getString("10km record", null)
            binding.textViewHalfMarathonTime.text = getString("Half-Marathon record", null)
            binding.textViewHalfMarathonDate.text = getString("Half-Marathon date", null)
            binding.textViewMarathonTime.text = getString("Marathon record", null)
            binding.textViewMarathonDate.text = getString("Marathon date", null)

        }
    }

    private fun setupClickListeners() {
        binding.container5km.setOnClickListener {
            // Navigate to 5km activity
            launchRunningRecordScreen("5km")
        }
        binding.container10km.setOnClickListener {
            launchRunningRecordScreen("10km")
        }
        binding.containerHalfMarathon.setOnClickListener {
            launchRunningRecordScreen("Half-Marathon")
        }
        binding.containerMarathon.setOnClickListener {
            launchRunningRecordScreen("Marathon")
        }
    }

    private fun launchRunningRecordScreen(distance: String) {
        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra(
            "Distance", distance
        )
        startActivity(intent)
    }
}
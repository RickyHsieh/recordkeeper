package com.purplestudio.recordkeeper.running

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.purplestudio.recordkeeper.databinding.ActivityEditRunnungRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRunnungRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunnungRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val distance = intent.getStringExtra("Distance")
        title = "$distance Record"
        displayRecord(distance)
        binding.buttonSave.setOnClickListener() {
            // Save the record
            saveRecord(distance)
            finish()
        }
    }

    private fun displayRecord(distance: String?) {
        val runningPreference = getSharedPreferences("running", MODE_PRIVATE)
        val record = runningPreference.getString("$distance record", null)
        val date = runningPreference.getString("$distance date", null)
        binding.editTextRecord.setText(record)
        binding.editTextDate.setText(date)
    }

    private fun saveRecord(distance: String?) {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()
        val runningPreference = getSharedPreferences("running", MODE_PRIVATE)
//        val editor = runningPreference.edit()
//        editor.putString("distance", distance)
//        editor.putString("date", date)
//        editor.apply()
        runningPreference.edit {
            putString("$distance record", record)
            putString("$distance date", date)
        }
    }
}
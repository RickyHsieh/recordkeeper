package com.purplestudio.recordkeeper.cycling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.purplestudio.recordkeeper.databinding.ActivityEditCyclingRecordBinding

class EditCyclingRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditCyclingRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var type = intent.getStringExtra("Type");
        title = "$type Record"
    }

}
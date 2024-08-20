package com.purplestudio.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.purplestudio.recordkeeper.cycling.CyclingFragment
import com.purplestudio.recordkeeper.databinding.ActivityMainBinding
import com.purplestudio.recordkeeper.running.RunningFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNav.setOnNavigationItemSelectedListener(this)
//        binding.buttonRunning.setOnClickListener { onRunningClicked() }
    }

    private fun onCyclingClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
    }

    private fun onRunningClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.nav_cycling) {
            onCyclingClicked()
        } else if(item.itemId == R.id.nav_running) {
            onRunningClicked()
        }
        return true
    }
}
package com.example.recordinglooper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), EmptySampleListFragment.Callbacks {
    private lateinit var samples: List<Sample>
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        samples = listOf()
        currentFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            loadSampleListFragment()
        }
    }

    private fun loadSampleListFragment() {
        val fragment = if (samples.isEmpty())
            EmptySampleListFragment()
        else
            SampleListFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

    private fun loadSampleCreationFragment() {
        val fragment = SampleCreationFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()

    }

    override fun onCreateSampleButtonClicked() {
        loadSampleCreationFragment()
    }
}
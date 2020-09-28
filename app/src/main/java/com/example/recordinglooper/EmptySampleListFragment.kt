package com.example.recordinglooper

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class EmptySampleListFragment : Fragment() {

    interface Callbacks {
        fun onCreateSampleButtonClicked()
    }

    private var callbacks: Callbacks? = null
    private lateinit var createSampleButton: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_empty_sample_list, container, false)
        createSampleButton = view.findViewById(R.id.record_sample_button) as Button
        createSampleButton.setOnClickListener {
            callbacks?.onCreateSampleButtonClicked()
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }
}
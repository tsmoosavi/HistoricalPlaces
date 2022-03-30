package com.example.historicalplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.historicalplaces.databinding.FragmentPersonalInfoEditBinding

class PersonalInfoEditFragment : Fragment() {
        lateinit var binding: FragmentPersonalInfoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalInfoEditBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
}
package com.example.historicalplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.historicalplaces.databinding.FragmentHomeBinding

class Home_Fragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstPlace()

    }

    private fun firstPlace() {
        context?.let {
            Glide.with(it)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcdSGphxGM4JUulkhcCsU4KuYxwIJsJ5oOng&usqp=CAU")
                .into(binding.image1)
        }
        binding.ll1.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }


}
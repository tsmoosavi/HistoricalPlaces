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
        secondPlace()
        thirdPlace()
        forthPlace()


    }

    private fun forthPlace() {
        context?.let {
            Glide.with(it)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQohoAxiP5fZ4qURf4wcTcjkHIgzb_U4DxMWw&usqp=CAU")
//                .transform(cropCircleTransformation(context))
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image4)
        }
        binding.ll4.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }

    private fun thirdPlace() {
        context?.let {
            Glide.with(it)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfoAez9VXW5YqYe6vlAILHRKHw4ajkU5qjdQ&usqp=CAU")
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image3)

        }
        binding.ll3.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }

    private fun secondPlace() {
        context?.let {
            Glide.with(it)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPWpEtc4bJm2AmjD9ZY9zEtRz5YXJxB-voZQ&usqp=CAU")
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image2)

        }
        binding.ll2.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }

    private fun firstPlace() {
        context?.let {
            Glide.with(it)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcdSGphxGM4JUulkhcCsU4KuYxwIJsJ5oOng&usqp=CAU")
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image1)
        }
        binding.ll1.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }


}
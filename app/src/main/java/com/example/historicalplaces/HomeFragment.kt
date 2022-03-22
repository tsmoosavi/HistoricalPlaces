package com.example.historicalplaces

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.historicalplaces.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val placesVm:placesDetailVm by activityViewModels ()
    var layoutList = arrayListOf<View>()
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
//       (binding.ll1,binding.ll2,binding.ll3, binding.ll4)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.ll1.setOnClickListener{
            var action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(placesVm.place1)
            findNavController().navigate(action)
        }
//        clicklistener()

    }

    private fun clicklistener() {
        for(i in 0 until layoutList.size)
       layoutList[i].setOnClickListener{
           var action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(placesVm.historicalPlacesList[i])
           findNavController().navigate(action)
        }
    }

    private fun initView() {
        firstPlace()
        secondPlace()
        thirdPlace()
        forthPlace()
    }
    private fun forthPlace() {

            Glide.with(this)
                .load(placesVm.place4.pictureURL)
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image4)
        binding.ll4.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }

    private fun thirdPlace() {
            Glide.with(this)
                .load(placesVm.place3.pictureURL)
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image3)

        binding.ll3.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }

    private fun secondPlace() {
            Glide.with(this)
                .load(placesVm.place2.pictureURL)
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image2)

        binding.ll2.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)
        }
    }

    private fun firstPlace() {
        Glide.with(this)
                .load(placesVm.place1.pictureURL)
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(binding.image1)

        binding.ll1.setOnClickListener{
            findNavController().navigate(R.id.action_home_Fragment_to_detailFragment)

        }
    }

    fun addList(){
        layoutList.add(binding.ll1)
        layoutList.add(binding.ll2)
        layoutList.add(binding.ll3)
        layoutList.add(binding.ll4)
    }


}
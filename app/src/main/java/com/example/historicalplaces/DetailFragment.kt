package com.example.historicalplaces

import android.os.Binder
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.historicalplaces.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDetailBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.activity_main_drawer, menu)
    }
}
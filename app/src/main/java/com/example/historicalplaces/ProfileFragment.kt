package com.example.historicalplaces

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.historicalplaces.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSavedInfo()
    }
    private fun showSavedInfo() {
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        binding.fullName.setText(saveInfo.getString("savedName",null))
        binding.id.setText(saveInfo.getString("savedId",null))
        binding.email.setText(saveInfo.getString("savedEmail",null))
        binding.address.setText(saveInfo.getString("savedAddress",null))
        binding.phone.setText(saveInfo.getString("savedPhone",null))
        Glide.with(this)
            .load(saveInfo.getString("urlPicture",null))
            .circleCrop()
            .error(R.drawable.ic_baseline_person_24)
            .into(binding.profileImage)

    }


}
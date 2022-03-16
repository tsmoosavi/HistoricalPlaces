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
        buttonClickListener()
        context?.let {
            Glide.with(it)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYXUA8i_XkolHaG72wChky5ycJP1xBBQ4gPA&usqp=CAU")
                .circleCrop()
                .error(R.drawable.ic_baseline_person_24)
                .into(binding.profileImage)
//
        }
    }
    private fun showSavedInfo() {
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
//        binding.fullName.setText(saveInfo.getString("savedName",null))

    }
    private fun buttonClickListener() {
        binding.register.setOnClickListener{
            if (isfielsFullAndCorrect()){
                saveInfo()

            }
        }
    }

    fun isfielsFullAndCorrect():Boolean{
        if (  binding.fullName.text.isNullOrBlank()){
            binding.fullName.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.id.text.isNullOrBlank()){
            binding.id.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.phone.text.isNullOrBlank()){
            binding.phone.error = "این فیلد را پر کنید."
            return false
        }
        return true
    }
    fun saveInfo(){
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        var editor = saveInfo.edit()
        editor.putString("savedName",binding.fullName.text.toString())
        editor.putString("savedUserName",binding.id.text.toString())
        editor.putString("savedmail",binding.phone.text.toString())
        editor.apply()
    }

}
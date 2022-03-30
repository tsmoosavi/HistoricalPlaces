package com.example.historicalplaces

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInfo()
        switch()
        binding.register.setOnClickListener{
            if (isfielsFull()){
                saveInfo()
            }
        }
    }

    private fun showInfo() {
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        binding.fullName.setText(saveInfo.getString("savedName",null))
        binding.id.setText(saveInfo.getString("savedId",null))
        binding.email.setText(saveInfo.getString("savedEmail",null))
        binding.address.setText(saveInfo.getString("savedAddress",null))
        binding.phone.setText(saveInfo.getString("savedPhone",null))
        binding.profilePicture.setText(saveInfo.getString("urlPicture",null))
        binding.showChoice.isChecked = saveInfo.getBoolean("showInfo",false)
    }

    private fun saveInfo() {
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        var editor = saveInfo.edit()
        editor.putString("savedName",binding.fullName.text.toString())
        editor.putString("savedId",binding.id.text.toString())
        editor.putString("savedEmail",binding.email.text.toString())
        editor.putString("savedAddress",binding.address.text.toString())
        editor.putString("savedPhone",binding.phone.text.toString())
        editor.putString("urlPicture",binding.profilePicture.text.toString())
        editor.apply()
        Toast.makeText(context,"مشخصات شما ثبت شد.",Toast.LENGTH_SHORT).show()


    }

    fun isfielsFull():Boolean{
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
        if(binding.email.text.isNullOrBlank()){
            binding.email.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.address.text.isNullOrBlank()){
            binding.address.error = "این فیلد را پر کنید."
            return false
        }
        if(binding.profilePicture.text.isNullOrBlank()){
            binding.profilePicture.error = "این فیلد را پر کنید."
            return false
        }
        return true
    }
    private fun switch() {
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        var editor = saveInfo.edit()
        binding.showChoice.setOnCheckedChangeListener { compoundButton, choice ->
            if (choice){
                editor.putBoolean("showInfo",true)
                editor.apply()
                Toast.makeText(context, "on", Toast.LENGTH_SHORT).show()
            }else {
                editor.putBoolean("showInfo",false)
                editor.apply()
                Toast.makeText(context,"off", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
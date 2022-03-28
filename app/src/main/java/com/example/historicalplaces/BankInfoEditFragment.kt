package com.example.historicalplaces

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.historicalplaces.databinding.FragmentBankInfoEditBinding

class BankInfoEditFragment : Fragment() {
   lateinit var binding: FragmentBankInfoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBankInfoEditBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveInfo()
    }

    private fun saveInfo() {
        var saveInfo : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        var editor = saveInfo.edit()
        editor.putString("accountNumber",binding.accountNumber.toString())
        editor.putString("cardNumber",binding.cardNumber.toString())
        editor.putString("shabaNumber",binding.shabaNumber.toString())
        editor.apply()
    }
}
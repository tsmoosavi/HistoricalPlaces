package com.example.historicalplaces



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.historicalplaces.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    val placeDetails:placesDetailVm by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_AUTO_TIME)
        setNumber()
        personalInfoEditButtonClick()
        bankInfoEditButtonClick()

        binding.seekBar.progress = placeDetails.numberOfViews
        binding.seekBarNumber.text = placeDetails.numberOfViews.toString()
        binding.dark.setOnClickListener{
            darkTheme()
        }
        binding.light.setOnClickListener{
            lightTheme()
        }
    }

    private fun bankInfoEditButtonClick() {
        binding.bankInfoEditBtn.setOnClickListener{
            findNavController().navigate(R.id.action_settingFragment_to_bankInfoEditFragment)
        }
    }

    private fun lightTheme() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
//        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_AUTO_TIME)
//        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
    }

    private fun darkTheme() {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
    }

    private fun personalInfoEditButtonClick() {
        binding.personalInfoEditBtn.setOnClickListener{
            findNavController().navigate(R.id.action_settingFragment_to_personalInfoEditFragment22)
        }
    }

    private fun setNumber() {
        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                placeDetails.numberOfViews = binding.seekBar.progress
                binding.seekBarNumber.text = placeDetails.numberOfViews.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }


}
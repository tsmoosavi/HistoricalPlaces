package com.example.historicalplaces

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.historicalplaces.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val placesVm:placesDetailVm by activityViewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        clicklistener()
        fabClick()

    }

    private fun fabClick() {
        binding.pointFab.setOnClickListener{
           showSentence(requireActivity())
        }
    }

    private fun showSentence(activity: Activity) {
        val builder: AlertDialog.Builder = activity.let {
            AlertDialog.Builder(it)
        }
        builder.setMessage(Repository.randomsentence())
            .setTitle("سخن نغز")
            .setPositiveButton("خب", DialogInterface.OnClickListener{ dialog, id->})
            .setCancelable(false)
            .show()


    }

    private fun clicklistener() {
        var layoutList = arrayListOf(binding.ll1, binding.ll2, binding.ll3, binding.ll4)
        for(i in 0 until layoutList.size)
       layoutList[i].setOnClickListener{
           var action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(placesVm.historicalPlacesList[i])
           findNavController().navigate(action)
        }
    }

    private fun initView() {
        var layoutList = arrayListOf(binding.ll1, binding.ll2, binding.ll3, binding.ll4)
        for(i in 0 until layoutList.size){
            layoutList[i].visibility = View.GONE
        }
        firstPlace()
        secondPlace()
        thirdPlace()
        forthPlace()
        for(i in 0 until placesVm.numberOfViews){
          layoutList[i].visibility = View.VISIBLE
        }
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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bankAccountInfoFragment -> {
                goToBankInfoPage()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToBankInfoPage() {
        findNavController().navigate(R.id.action_home_Fragment_to_bankAccountInfoFragment)
    }



}
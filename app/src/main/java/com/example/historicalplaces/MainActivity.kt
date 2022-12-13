package com.example.historicalplaces

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.*
import com.example.historicalplaces.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
   lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBar.toolbar)
//        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_Fragment, R.id.profileFragment, R.id.settingFragment, R.id.exit
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.exit ->{
                    finish()
                    true
                }
            }
            NavigationUI.onNavDestinationSelected(it, navController)
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
//        navView.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.home_menu, menu)
//        return true
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.bankAccountInfoFragment -> {
//                goToBankInfoPage()
//                    true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

//    private fun goToBankInfoPage() {
//        Navigation.findNavController( this, R.id.nav_host_fragment_content_main) .navigate(R.id.action_home_Fragment_to_bankAccountInfoFragment)
//        Navigation.findNavController(this, R.id.nav_host_fragment_content_main).navigate(R.id.bankAccountInfoFragment)

//    }
}
package com.kareemdev.projectbottombarcustom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.kareemdev.projectbottombarcustom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        binding.fabQr.setOnClickListener {
            Toast.makeText(this, "Coming Soon!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupViews() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottom, navHostFragment.navController)
        navController.addOnDestinationChangedListener{ controller, destination, arguments ->
            when(destination.id){
                R.id.homeFragment -> showBottomNavigation()
                R.id.profileFragment -> showBottomNavigation()
                R.id.aboutFragment -> showBottomNavigation()
                R.id.settingsFragment -> showBottomNavigation()
                else -> hideBottomNavigation()
            }
        }
    }

    private fun hideBottomNavigation() {
        binding.bottom.visibility = View.GONE
    }

    private fun showBottomNavigation() {
        binding.bottom.visibility = View.VISIBLE
    }
}
package com.example.squads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.squads.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = this.findNavController(R.id.nav_host_fragment_activity_main)
        setupMenu()

        supportActionBar?.hide() //temporary solution
    }

    /**
     * handles the bottom navigation
     */
    private fun setupMenu() {
        // Setup the bottom navigation view with navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigationView.setupWithNavController(navController)

        // Specify the fragments in a Set Collection
        // They're used in the same order as defined in the Collection
        // e.g. home fragment shows at the first menu item in the action bar
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home, R.id.reservations, R.id.settings)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
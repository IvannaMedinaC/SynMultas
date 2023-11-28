package co.edu.unal.synmultas.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import co.edu.unal.synmultas.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(findViewById(R.id.toolbar2))

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfig = AppBarConfiguration(setOf(
            R.id.myFinesFragment,
            R.id.chatBotFragment,
            R.id.settingsFragment
        ))
        setupActionBarWithNavController(navController,appBarConfig)
        bottomNavigationView.setupWithNavController(navController)
    }
}
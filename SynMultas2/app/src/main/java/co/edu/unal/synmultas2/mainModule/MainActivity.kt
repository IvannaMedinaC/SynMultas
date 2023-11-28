package co.edu.unal.synmultas2.mainModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import co.edu.unal.synmultas2.R
import co.edu.unal.synmultas2.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel() {
        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mMainViewModel.getFines().observe(this) { stores ->

        }

    }

}
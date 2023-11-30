package co.edu.unal.synmultas2.mainModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import co.edu.unal.synmultas2.R
import co.edu.unal.synmultas2.chatModule.ChatBotFragment
import co.edu.unal.synmultas2.common.entities.FineEntity
import co.edu.unal.synmultas2.common.utils.MainAux
import co.edu.unal.synmultas2.databinding.ActivityMainBinding
import co.edu.unal.synmultas2.mainModule.adapter.FineAdapter
import co.edu.unal.synmultas2.mainModule.adapter.OnClickListener
import co.edu.unal.synmultas2.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), OnClickListener, MainAux {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: FineAdapter
    private lateinit var mGridLayout: GridLayoutManager

    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupViewModel()
        setupRecyclerView()

        mBinding.fab.setOnClickListener { launchChatBotFragment() }
    }

    private fun setupRecyclerView() {
        mAdapter = FineAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 1)

        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    private fun launchChatBotFragment() {
        hideFab(false)
        val fragment = ChatBotFragment()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.containerMain, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun setupViewModel() {
        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        intent.getStringExtra("plate")?.let { mMainViewModel.setPlate(it) }

        mMainViewModel.getFines().observe(this) { fines ->
            mAdapter.setFines(fines)
        }

    }

    override fun hideFab(isVisible: Boolean) {
        if(isVisible) mBinding.fab.show() else mBinding.fab.hide()
    }

    override fun onClick(fineEntity: FineEntity) {
        launchViewFragment(fineEntity)
    }

    private fun launchViewFragment(fineEntity: FineEntity) {
        TODO("Not yet implemented")
    }

}
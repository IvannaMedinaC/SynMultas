package co.edu.unal.synmultas.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import co.edu.unal.synmultas.R
import co.edu.unal.synmultas.databinding.FragmentMyFinesBinding
import co.edu.unal.synmultas.ui.adapter.FineAdapter
import co.edu.unal.synmultas.viewModel.MyFinesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyFinesFragment : Fragment(){

    private lateinit var binding: FragmentMyFinesBinding
    private val viewModel: MyFinesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_my_fines,container,false)
        binding.adapter = FineAdapter(listOf(),viewModel)

        viewModel.showToast.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { fine ->
                Toast.makeText(this.context, "MovieClicked: ${fine.title}", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = this@MyFinesFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}

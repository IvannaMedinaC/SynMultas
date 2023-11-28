package co.edu.unal.synmultas.ui.adapter

import co.edu.unal.synmultas.R
import co.edu.unal.synmultas.databinding.ItemFineBinding
import co.edu.unal.synmultas.model.FineModel
import co.edu.unal.synmultas.ui.adapter.base.BaseAdapter

class FineAdapter(
    private val list: List<FineModel>,
    private val fineListener: FineListener
): BaseAdapter<ItemFineBinding, FineModel>(list) {
    override val layoutId: Int = R.layout.item_fine

    override fun bind(binding: ItemFineBinding, item: FineModel) {
        binding.apply {
            fine = item
            listener = fineListener
            executePendingBindings()
        }
    }
}

interface FineListener {
    fun onFineClicked(fine: FineModel)
}
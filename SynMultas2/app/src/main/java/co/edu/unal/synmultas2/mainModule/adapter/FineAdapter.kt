package co.edu.unal.synmultas2.mainModule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.unal.synmultas2.R
import co.edu.unal.synmultas2.common.entities.FineEntity
import co.edu.unal.synmultas2.databinding.ItemFineBinding
import java.text.NumberFormat
import java.util.Locale

class FineAdapter(private var fines: MutableList<FineEntity>,
                  private var listener: OnClickListener):
    RecyclerView.Adapter<FineAdapter.ViewHolder>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FineAdapter.ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_fine, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FineAdapter.ViewHolder, position: Int) {
        val fine = fines[position]

        with(holder){
            setListener(fine)

            binding.fineCity.text=fine.ciudad
            binding.fineDepartment.text=fine.departamento
            binding.fineDate.text=fine.fecha_multa
            binding.finePlate.text=fine.placa
            binding.finePrice.text=formatCOP(fine.valor_multa)
            binding.finePaid.text=fine.pagado_si_no

        }
    }

    override fun getItemCount(): Int = fines.size

    fun setFines(fines: List<FineEntity>) {
        this.fines = fines as MutableList<FineEntity>
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemFineBinding.bind(view)

        fun setListener(fineEntity: FineEntity){
            binding.root.setOnClickListener { listener.onClick(fineEntity) }
        }
    }

    private fun formatCOP(value: String): String{
        val format = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        return format.format(value.toDouble())
    }
}
package co.edu.unal.synmultas.model

import co.edu.unal.synmultas.ui.adapter.base.ListAdapterItem
import java.io.Serializable

data class FineModel(
    val title: String = "",
    val date: String = "",
    val value: String = "",
    val place: String = "",
    val motive: String = "",
    override val id: Long = 0
): ListAdapterItem, Serializable
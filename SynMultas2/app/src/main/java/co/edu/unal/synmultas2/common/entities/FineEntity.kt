package co.edu.unal.synmultas2.common.entities

data class FineEntity(
    val vigencia: String,
    val placa: String,
    val fecha_multa: String,
    val valor_multa: String,
    val departamento: String,
    val ciudad: String,
    val pagado_si_no: String
)

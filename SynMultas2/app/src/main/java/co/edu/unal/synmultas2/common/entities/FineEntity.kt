package co.edu.unal.synmultas2.common.entities

data class FineEntity(
    val validity: String,
    val licencePlate: String,
    val fineDate: String,
    val fineValue: Long,
    val department: String,
    val city: String,
    val isPaid: String
)

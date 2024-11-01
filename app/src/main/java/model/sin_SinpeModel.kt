package cr.ac.utn.movil.model

import cr.ac.utn.movil.identities.Identifier

data class sin_SinpeModel(
    val sin_id: Long,
    val sin_phoneNumber: String,
    val sin_destName: String,
    val sin_amount: Double,
    val sin_description: String,
    val sin_dateTime: String
) : Identifier()

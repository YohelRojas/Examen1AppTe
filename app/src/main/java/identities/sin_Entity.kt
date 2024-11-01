package cr.ac.utn.movil.entity

import cr.ac.utn.movil.identities.Identifier
import java.io.Serializable

data class sin_Entity(
    val sin_originPerson: String,
    val sin_destinationName: String,
    val sin_phoneNumber: String,
    val sin_amount: Double,
    val sin_description: String,
    val sin_dateTime: String
) : Identifier(), Serializable {

    override val FullDescription: String
        get() = "Origin: $sin_originPerson, Destination: $sin_destinationName, Amount: $sin_amount"
}

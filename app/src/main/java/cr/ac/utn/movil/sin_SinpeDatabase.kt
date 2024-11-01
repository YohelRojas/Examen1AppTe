package cr.ac.utn.movil.data

import cr.ac.utn.movil.model.sin_SinpeModel

class sin_SinpeDatabase {

    private val sinpeList = mutableListOf<sin_SinpeModel>()

    fun addSinpe(sinpe: sin_SinpeModel) {
        sinpeList.add(sinpe)
    }

    fun deleteSinpe(id: Long) {
        sinpeList.removeIf { it.sin_id == id }
    }

    fun updateSinpe(sinpe: sin_SinpeModel) {
        val index = sinpeList.indexOfFirst { it.sin_id == sinpe.sin_id }
        if (index != -1) sinpeList[index] = sinpe
    }

    fun getAllSinpes(): List<sin_SinpeModel> = sinpeList

    fun isDuplicate(sinpe: sin_SinpeModel): Boolean {
        return sinpeList.any { it.sin_phoneNumber == sinpe.sin_phoneNumber && it.sin_dateTime == sinpe.sin_dateTime }
    }
}

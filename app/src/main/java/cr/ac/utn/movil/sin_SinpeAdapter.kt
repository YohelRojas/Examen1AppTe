package cr.ac.utn.movil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cr.ac.utn.movil.R
import cr.ac.utn.movil.model.sin_SinpeModel

class sin_SinpeAdapter(private var sinpeList: List<sin_SinpeModel>) :
    RecyclerView.Adapter<sin_SinpeAdapter.SinpeViewHolder>() {

    // ViewHolder es la clase que gestiona cada vista individual de la lista
    inner class SinpeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val phoneNumber: TextView = view.findViewById(R.id.phoneNumber)
        val destName: TextView = view.findViewById(R.id.destName)
        val amount: TextView = view.findViewById(R.id.amount)
        val description: TextView = view.findViewById(R.id.description)
        val dateTime: TextView = view.findViewById(R.id.dateTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SinpeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sin_list_item, parent, false)
        return SinpeViewHolder(view)
    }

    override fun onBindViewHolder(holder: SinpeViewHolder, position: Int) {
        val sinpe = sinpeList[position]
        holder.phoneNumber.text = sinpe.sin_phoneNumber
        holder.destName.text = sinpe.sin_destName
        holder.amount.text = sinpe.sin_amount.toString()
        holder.description.text = sinpe.sin_description
        holder.dateTime.text = sinpe.sin_dateTime
    }

    override fun getItemCount() = sinpeList.size


    fun updateData(newData: List<sin_SinpeModel>) {
        sinpeList = newData
        notifyDataSetChanged()
    }
}

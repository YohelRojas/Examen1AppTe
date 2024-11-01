package cr.ac.utn.movil

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cr.ac.utn.movil.model.sin_SinpeModel
import cr.ac.utn.movil.data.sin_SinpeDatabase
import cr.ac.utn.movil.adapter.sin_SinpeAdapter

class sin_MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: sin_SinpeAdapter
    private lateinit var database: sin_SinpeDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sin_main_menu)

        database = sin_SinpeDatabase(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = sin_SinpeAdapter(database.getAllSinpes())
        recyclerView.adapter = adapter
    }

    private fun addSinpe(sinpe: sin_SinpeModel) {
        if (!database.isDuplicate(sinpe)) {
            database.addSinpe(sinpe)
            adapter.updateData(database.getAllSinpes())
            Toast.makeText(this, "Sinpe agregado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error: Sinpe duplicado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteSinpe(id: Long) {
        database.deleteSinpe(id)
        adapter.updateData(database.getAllSinpes())
        Toast.makeText(this, "Sinpe eliminado", Toast.LENGTH_SHORT).show()
    }

    private fun updateSinpe(sinpe: sin_SinpeModel) {
        database.updateSinpe(sinpe)
        adapter.updateData(database.getAllSinpes())
        Toast.makeText(this, "Sinpe actualizado", Toast.LENGTH_SHORT).show()
    }
}

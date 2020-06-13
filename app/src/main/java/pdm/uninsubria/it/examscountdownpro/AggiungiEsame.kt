package pdm.uninsubria.it.examscountdownpro

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_aggiungi_esame.*
import java.util.*

class AggiungiEsame : AppCompatActivity() {

    private val database = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aggiungi_esame)

        //Settaggio di un nuovo titolo per la nuova activity
        supportActionBar?.title="Aggiungi nuovo esame"

        val nome = findViewById<EditText>(R.id.editText4)
        val argomento = findViewById<EditText>(R.id.editText6)
        val data = findViewById<EditText>(R.id.editText5)

        //dichiarazione Button listener
        val button = findViewById<Button>(R.id.buttonAdd)

        //funzione del bottone
        button.setOnClickListener(View.OnClickListener { addEsame(nome.text.toString(), argomento.text.toString(), data.text.toString()) })

    }

    //Settaggio per mostrare l'incona Annulla per tornare indietro
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.back_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_back -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

     fun openCalendar (view: View) {

        val calendar= Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        { view, year, monthOfYear, dayOfMonth ->

            editText5.setText("" + dayOfMonth + " - " + (monthOfYear+1) + " - " + year)

        }, year, month, day)

        datePickerDialog.show()

    }

    fun addEsame (nome : String, argomento : String, data : String) {
        val esame : MutableMap <String, Any> = HashMap()
        esame ["nome"] = nome
        esame ["argomento"] = argomento
        esame ["data"] = data
        database.collection("Esami").document("Appello" + nome).set(esame)
    }

}

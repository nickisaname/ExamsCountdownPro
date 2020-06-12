package pdm.uninsubria.it.examscountdownpro

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_aggiungi_esame.*
import java.util.*

class AggiungiEsame : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aggiungi_esame)

        //Titolo sulla toolbar
        supportActionBar?.title = "Aggiungi nuovo esame"
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
    fun AggiungiItem(){
        val bt : Button = findViewById(R.id.buttonAdd)
        bt.setOnClickListener(){
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }
    }

}



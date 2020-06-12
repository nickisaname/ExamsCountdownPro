package pdm.uninsubria.it.examscountdownpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        database = Firebase.database.reference
        // variabili che servono da variabili nel db che ancora non so usare ma che imparerò ad usare
        //val myRef = database.getReference("message")
        //myRef.setValue("Hello, World!)"


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.add_button, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                aggiungiEsame()
                true
            }
            R.id.action_delete -> {
                rimuoviEsame()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun aggiungiEsame () {
        val it = Intent(this, AggiungiEsame::class.java)
        startActivity(it)
    }

    fun rimuoviEsame () {

    }




}

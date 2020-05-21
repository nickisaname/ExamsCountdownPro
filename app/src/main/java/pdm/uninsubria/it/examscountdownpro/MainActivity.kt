package pdm.uninsubria.it.examscountdownpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        setContentView(R.layout.activity_aggiungi_esame)
    }

    fun rimuoviEsame () {

    }

}

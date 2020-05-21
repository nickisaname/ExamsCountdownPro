package pdm.uninsubria.it.examscountdownpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class AggiungiEsame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aggiungi_esame)

        supportActionBar?.title = "Aggiungi un nuovo esame"
    }

}

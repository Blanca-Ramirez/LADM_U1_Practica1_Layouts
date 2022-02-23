package mx.tecnm.tepic.ladm_u1_practica1_blanca

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_scrolling.*
import mx.tecnm.tepic.ladm_u1_practica1_blanca.databinding.ActivityScrollingBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //leerArchivo()
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            leerArchivo()
        }
    }
    private fun leerArchivo(){
        try {
            var archivo = BufferedReader(InputStreamReader(openFileInput("archivo.txt")))
            var cadena = archivo.readLine()
            cadena = cadena.replace("&&","\n")
            AlertDialog.Builder(this).setMessage(cadena).show()
        }catch(e:Exception){
            AlertDialog.Builder(this).setMessage(e.message).show()
        }
    }
}
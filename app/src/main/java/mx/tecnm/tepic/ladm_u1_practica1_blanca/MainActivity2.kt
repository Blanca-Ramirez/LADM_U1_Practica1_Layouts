package mx.tecnm.tepic.ladm_u1_practica1_blanca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main4.*
import mx.tecnm.tepic.ladm_u1_practica1_blanca.databinding.ActivityMain4Binding
import mx.tecnm.tepic.ladm_u1_practica1_blanca.databinding.ActivityMainBinding
import java.io.OutputStreamWriter


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        rpedido.setOnClickListener {
            guardarArchivo()
            llamaractivity()
        }
    }
    private fun llamaractivity() {
        val otraactivity = Intent(this, ScrollingActivity::class.java)
        startActivity(otraactivity)
    }
    private fun guardarArchivo(){
        try {
            val archivo = OutputStreamWriter(openFileOutput("archivo.txt", MODE_PRIVATE))
            var cadena2 = "Orden: &&"
            if (curry1.isChecked){
                cadena2+=" • Curry&&"
            }
            if (hotcake1.isChecked){
                cadena2+=" • Hot Cake&&"
            }
            if (sandwich1.isChecked){
                cadena2+=" • Sandwich&&"
            }
            var cadena = "Datos Personales:&&Nombre: "+nombre.text.toString()+"&&Domicilio: "+
                    domicilio.text.toString()+"&& &&"+
                    cadena2
            archivo.write(cadena)
            archivo.flush()
            archivo.close()
            nombre.setText("")
        }catch (e:Exception){
            AlertDialog.Builder(this).setMessage(e.message).show()
        }
    }
}
package com.example.task08guiloginyregistro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Registros : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)
        var recogidaArray = intent.getStringArrayListExtra("ArrayUsuarios")

        //Al pulsar el boton de registrar, se guarda el nombre de usuario en el array y se pasa a la actividad vacía

        findViewById<Button>(R.id.registrar).setOnClickListener{
            recogidaArray?.add(findViewById<TextView>(R.id.nombreU).toString())
            var intento = Intent(this, Siguiente::class.java)
            startActivity(intento)
        }

        //Al pulsar el boton de cancelar, vuelve a la pantalla inicial (la pantalla de login)

        findViewById<Button>(R.id.cancelar).setOnClickListener{
            var intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }
    }
}
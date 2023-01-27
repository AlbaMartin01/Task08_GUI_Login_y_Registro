package com.example.task08guiloginyregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayUsuarios = ArrayList<String>()
        var nombreUsuario = findViewById<TextView>(R.id.nombreUsuario).toString()

        findViewById<Button>(R.id.botonLogin).setOnClickListener{
            if (arrayUsuarios.contains(nombreUsuario)){
                var intento = Intent(this, Registro::class.java)
                intento.putExtra("ArrayUsuarios", arrayUsuarios)
                startActivity(intento)
            }else{
                println("El usuario no existe. Tienes que registrarte en el botón 'Registro'.")
            }
        }

        findViewById<Button>(R.id.botonRegistro).setOnClickListener{
            if (arrayUsuarios.contains(nombreUsuario)){
                println("El usuario ya está reistrado. Pulse el botón 'Login' para logearse.")
            } else{
                var intento = Intent(this, Registro::class.java)
                intento.putExtra("ArrayUsuarios", arrayUsuarios)
                startActivity(intento)
            }
        }
    }
}
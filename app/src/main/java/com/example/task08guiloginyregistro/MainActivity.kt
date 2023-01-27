package com.example.task08guiloginyregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se crean dos variables, una para comprobar y guardar usuarios

        var arrayUsuarios = ArrayList<String>()
        var nombreUsuario = findViewById<TextView>(R.id.nombreUsuario).toString()

        //Si pulsa el boton Login, se comprueba si esta metido en el arrayList. Si está metido, pasa a la siguiente pantalla, sino, salta un mensaje

        findViewById<Button>(R.id.botonLogin).setOnClickListener{
            if (arrayUsuarios.contains(nombreUsuario)){
                var intento = Intent(this, Siguiente::class.java)
                intento.putExtra("ArrayUsuarios", arrayUsuarios)
                startActivity(intento)
            } else{
                var mens = "El usuario no existe. Tienes que registrarte en el botón 'Registro'."
                Toast.makeText(this@MainActivity, mens, Toast.LENGTH_LONG).show()
            }
        }

        //Comprueba que el usuario ya esta registrado. si ya esta registrado, salta un mensaje, sino, pasa a la pantalla de Registro

        findViewById<Button>(R.id.botonRegistro).setOnClickListener{
            if (arrayUsuarios.contains(nombreUsuario)){
                var mens = "El usuario ya está reistrado. Pulse el botón 'Login' para logearse."
                Toast.makeText(this@MainActivity, mens, Toast.LENGTH_LONG).show()
            } else{
                var intento = Intent(this, Registros::class.java)
                intento.putExtra("ArrayUsuarios", arrayUsuarios)
                startActivity(intento)
            }
        }
    }
}
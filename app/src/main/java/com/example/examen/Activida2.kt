package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Activida2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)


        // volver al menu
        val volver: ImageView = findViewById(R.id.Volver)
        volver.setOnClickListener {
            volverAlMain()
        }
    }


    fun volverAlMain() {
        // Crear un Intent para volver a MainActivity
        val intent = Intent(this, MainActivity::class.java)

        // Iniciar la actividad MainActivity
        startActivity(intent)

        // Opcional: Finalizar la actividad actual para que no quede en la pila de actividades
        finish()
    }
}
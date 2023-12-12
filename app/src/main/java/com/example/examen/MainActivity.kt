 package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


        val btn1 = findViewById<Button>(R.id.btnActividad1)
        val btn2 =  findViewById<Button>(R.id.btnActividad2)
        btn1.setOnClickListener {
            // Cuando se hace clic en el botón, inicia la nueva actividad
            val intent = Intent(this, Actividad1::class.java)
            startActivity(intent)
        }

        btn1.setOnClickListener {
            // Cuando se hace clic en el botón, inicia la nueva actividad
            val intent = Intent(this, Activida2::class.java)
            startActivity(intent)
        }

    }
}
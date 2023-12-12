package com.example.examen

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Actividad1:AppCompatActivity () {

    private lateinit var layFecha: TextInputLayout
    private lateinit var tFecha: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uno)



        layFecha = findViewById(R.id.layFech)
        tFecha = findViewById(R.id.tFechaCaptura)


        // Configurar el clic en el TextInputEditText para mostrar el DatePicker
        tFecha.setOnClickListener {
            mostrarDatePicker()
        }

        // volver al menu
        val volver: ImageView = findViewById(R.id.Volver)
        volver.setOnClickListener {
            volverAlMain()
        }

        val btnVerificar = findViewById<Button>(R.id.valida)
        btnVerificar.setOnClickListener {
            verificarFormulario()
        }
        //seccion spinner
        // Obtener referencia al Spinner desde el layout
        val spinner = findViewById<Spinner>(R.id.spinnerOpciones)

        // Obtener la lista de opciones del array en strings.xml
        val opciones = resources.getStringArray(R.array.opciones_spinner)

        // Crear un adaptador para el Spinner
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

        // Establecer el estilo del desplegable
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item)

        // Configurar el adaptador en el Spinner
        spinner.adapter = adaptador

        // Manejar la selección del Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: android.view.View,
                position: Int,
                id: Long
            ) {
                // Acciones a realizar cuando se selecciona un elemento
                val opcionSeleccionada = opciones[position]
                showToast("Seleccionaste: $opcionSeleccionada")
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Acciones a realizar cuando no se selecciona ningún elemento
            }
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

    private fun verificarFormulario() {
        //validar nombre
        val nombreLayout = findViewById<TextInputLayout>(R.id.layNombre)
        val nombre = validarNombre(nombreLayout)

        //validar entreandro
        val entrenadorLayout = findViewById<TextInputLayout>(R.id.layEntrenador)
        val entrenador =nombreEntreando(tEntrenador)


    }

    // validaar entrenador
    fun validarEntrenador(nombre: String): Boolean {
        // Verificar la longitud del nombre

        val entreNombre = findViewById<TextInputLayout>(R.id.layEntrenador)
        val entrenador =entreNombre(tEntrenador)
        if (nombre.length < 25) {
            return true

        } else{

            nombre.error = "No puede ser mas de 25 caracteees"

        }

        // Verificar si hay al menos una vocal
        val tieneVocal = nombre.any { it.toLowerCase() in "aeiou" }

        return tieneVocal
    }





    private fun volverAlMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Esto cierra la actividad actual para liberar recursos
    }


    private fun validarNombre(nombreLayout: TextInputLayout): Boolean {
        val nombreEditText = nombreLayout.findViewById<TextInputEditText>(R.id.tNombre)
        val nombre = nombreEditText.text.toString()
        return if (nombre.isNotEmpty() && nombre[0].isUpperCase() && nombre.length >= 3) {
            true
        } else {
            nombreLayout.error = "El nombre debe comenzar con mayúscula"
            false
        }
    }


    //validar fechar

    private fun mostrarDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Actualizar el TextInputEditText con la fecha seleccionada
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)

                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                tFecha.setText(formattedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    // verificar que la fecha no sea superior a la acutal


}
package com.example.edgarvazquezcamargo.proyectokotlin

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

data class Cursos(val nombre: String,val url: String)
class ActividadPrincipal : Activity() {
    val react = Cursos("react","platzi.com/react")
    val kotlin = Cursos("kotlin","platzi.com/kotlin")
    var actual = react

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_principal)
        val boton = findViewById(R.id.btnCambio) as Button
        boton.setOnClickListener {
            val txt = findViewById(R.id.mensaje) as TextView
            txt.setText(cambiarTexto())
        }

        val lista = findViewById(R.id.lista) as ListView
        lista.adapter = MyBaseAdapter(this)
        lista.setOnItemClickListener { parent, view, position, id ->
            println("${position} y ${id}")
            println("Este evento pertenece a ${lista.adapter.getItem(position)}")
        }
    }

    fun cambiarTexto():String{
        //val txt = findViewById(R.id.mensaje) as TextView
        val nombre = actual.nombre
        when(actual.nombre){
            "react"->{
                actual = kotlin
            }
            "kotlin"-> actual=react
        }
        return nombre
    }
}

package com.oscargnu.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)  // Asegúrate de que este archivo sea el correcto

        val btnEntrar: Button = findViewById(R.id.btn_entrar)
        btnEntrar.setOnClickListener {
            goBtnEntrar()
            Toast.makeText(this, "¡Botón clickeado!", Toast.LENGTH_SHORT).show() // Revisar esta linea para que funciona
        }
    }

    private fun goBtnEntrar() {
        val intent = Intent(this, CaclculatorActivity::class.java)
        startActivity(intent)
    }
}


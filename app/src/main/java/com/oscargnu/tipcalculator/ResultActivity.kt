package com.oscargnu.tipcalculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)

        // Recibir los datos enviados desde CaclculatorActivity
        val totalAmount = intent.getDoubleExtra("totalAmount", 0.0)
        val numPeople = intent.getIntExtra("numPeople", 1)
        val percentage = intent.getIntExtra("percentage", 0)
        val tipAmount = intent.getDoubleExtra("tipAmount", 0.0)
        val totalWithTip = intent.getDoubleExtra("totalWithTip", 0.0)
        val amountPerPerson = intent.getDoubleExtra("amountPerPerson", 0.0)

        // Mostrar los resultados en los TextViews
        val tvAccount: TextView = findViewById(R.id.tvAccount)
        val tvNumPeople: TextView = findViewById(R.id.tvNumPeople)
        val tvTipPercentage: TextView = findViewById(R.id.tvTipPercentage)
        val tvTotalWithTip: TextView = findViewById(R.id.tvTotalWithTip)
        val tvAmountPerPerson: TextView = findViewById(R.id.tvAmountPerPerson)

        tvAccount.text = "Total account: ${"%.2f".format(totalAmount)}"
        tvNumPeople.text = "Number of persons: $numPeople"
        tvTipPercentage.text = "Percentage of gratuity: $percentage%"
        tvTotalWithTip.text = "Total with tip: ${"%.2f".format(totalWithTip)}"
        tvAmountPerPerson.text = "Amount per person: ${"%.2f".format(amountPerPerson)}"
    }

    // Función para regresar a la actividad anterior
    fun goBack(view: View) {
        finish()
    }
}
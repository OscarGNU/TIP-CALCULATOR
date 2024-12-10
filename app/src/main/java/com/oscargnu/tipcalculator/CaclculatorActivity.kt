package com.oscargnu.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

const val key_calculo  = "calculo.key_imc"
class CaclculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_caclculator)

        var percentage: Int = 0
        val optionOne: RadioButton = findViewById(R.id.rb_option_one)
        val optionTwo: RadioButton = findViewById(R.id.rb_option_two)
        val optionThree: RadioButton = findViewById(R.id.rb_option_three)
        val btnClean: Button = findViewById(R.id.btn_cleaning)
        val btnDone: Button = findViewById(R.id.btn_done)
        val edtTotal: TextInputEditText = findViewById(R.id.tie_account)
        val edtNumPeople: TextInputEditText = findViewById(R.id.tie_total_number_people)

        // Establecer la acción de los RadioButton
        optionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }

        optionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }

        optionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }

        // Botón "Calcular"
        btnDone.setOnClickListener {
            val totalStr = edtTotal.text.toString()
            val numPeopleStr = edtNumPeople.text.toString()

            if (totalStr.isNotEmpty() && numPeopleStr.isNotEmpty()) {
                val totalAmount = totalStr.toDouble() // Cuenta total
                val numPeople = numPeopleStr.toInt() // Número de personas

                // Calcular la propina
                val tipAmount = totalAmount * (percentage / 100.0)
                // Calcular el total con propina
                val totalWithTip = totalAmount + tipAmount
                // Calcular el monto por persona (total con propina / número de personas)
                val amountPerPerson = totalWithTip / numPeople

                // Crear un Intent para pasar los datos a ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("totalAmount", totalAmount)
                intent.putExtra("numPeople", numPeople)
                intent.putExtra("percentage", percentage)
                intent.putExtra("tipAmount", tipAmount)
                intent.putExtra("totalWithTip", totalWithTip)
                intent.putExtra("amountPerPerson", amountPerPerson)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingrese la cuenta y el número de personas.", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón "Limpiar"
        btnClean.setOnClickListener {
            edtTotal.text?.clear()
            edtNumPeople.text?.clear()
            optionOne.isChecked = false
            optionTwo.isChecked = false
            optionThree.isChecked = false
        }
    }
}


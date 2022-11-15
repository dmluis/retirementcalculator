package kotlinbook.com.retirementcalculator

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState:   Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_age = findViewById<EditText>(R.id.txt_age)
        val btn_calculate = findViewById<Button>(R.id.btn_calculate)
        val txt_result = findViewById<TextView>(R.id.txt_result)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("masculino", "feminino"))

        btn_calculate.setOnClickListener {
            val sexo = spn_sexo.selectedItem as String
            val age = txt_age.text.toString().toInt()
            var result = 0
            if (sexo == "masculino") {
                result = 65 - age
            } else {
                result = 60 - age
            }
            txt_result.text = "Faltam $result anos para você se aposentar."
        }

    }
}
package com.example.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder


import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b0: Button = findViewById(R.id.button13)
        val b1: Button = findViewById(R.id.button9)
        val b2: Button = findViewById(R.id.button10)
        val b3: Button = findViewById(R.id.button11)
        val b4: Button = findViewById(R.id.button6)
        val b5: Button = findViewById(R.id.button7)
        val b6: Button = findViewById(R.id.button8)
        val b7: Button = findViewById(R.id.button)
        val b8: Button = findViewById(R.id.button2)
        val b9: Button = findViewById(R.id.button3)
        val bdote: Button = findViewById(R.id.button12)
        val bequal: Button = findViewById(R.id.button17)
        val bplus: Button = findViewById(R.id.button18)
        val bminus: Button = findViewById(R.id.button16)
        val bmulti: Button = findViewById(R.id.button15)
        val bdevide: Button = findViewById(R.id.button14)
        val bc: Button = findViewById(R.id.button5)
        val bce: Button = findViewById(R.id.button4)
        val resultat: TextView = findViewById(R.id.resultat)
        val expression: TextView = findViewById(R.id.expression)

        fun Saisir(contenu:String,clear:Boolean){
            if(resultat.text.isNotEmpty())
                expression.text= ""
            if(clear){
                resultat.text = ""
                expression.append(contenu)
            }
            else{
                expression.append(resultat.text)
                expression.append(contenu)
                resultat.text = ""
            }
        }




        b0.setOnClickListener {Saisir("0", true) }
        b1.setOnClickListener {Saisir("1", true) }
        b2.setOnClickListener {Saisir("2", true) }
        b3.setOnClickListener {Saisir("3", true) }
        b4.setOnClickListener {Saisir("4", true) }
        b5.setOnClickListener {Saisir("5", true) }
        b6.setOnClickListener {Saisir("6", true) }
        b7.setOnClickListener {Saisir("7", true) }
        b8.setOnClickListener {Saisir("8", true) }
        b9.setOnClickListener {Saisir("9", true) }
        bdote.setOnClickListener {Saisir(".", true) }

        bplus.setOnClickListener {Saisir("+", false) }
        bminus.setOnClickListener {Saisir("-", false) }
        bmulti.setOnClickListener {Saisir("*", false) }
        bdevide.setOnClickListener {Saisir("/", false) }

        bc.setOnClickListener {
            resultat.text = ""
            expression.text = ""}
        bce.setOnClickListener {
            val str = expression.text.toString()
            if(str.isNotEmpty()){
                expression.text = str.substring(0,str.length-1)
            }
            resultat.text = ""
        }
        bequal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(expression.text.toString()).build()
                val result = ex.evaluate()
                val longresult = result.toLong()
                if (result==longresult.toDouble())
                    resultat.text = longresult.toString()
                else
                    resultat.text = result.toString()
            }catch (e:Exception){
                Log.d("Exception","message:"+e.message)
            }

        }




    }





}
package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import com.example.gastoviagem.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val actionBar = supportActionBar
        supportActionBar!!.title = "By Miguel Cavalcante"//Action bar title

        super.onCreate(savedInstanceState)
        //View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener(this)
        binding.clear.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (v.id == R.id.calculate) { //se o clicado for o botão de calcular
            calculateFun()
        }

        if (v.id == R.id.clear) { //Limpar
            clearFun()
        }
    }

    fun validate(): Boolean {
        return (binding.distance.text.toString() != ""
                && binding.autonomy.text.toString() != ""
                && binding.autonomy.text.toString() != ""
                && binding.distance.text.toString().toFloat() != 0f
                && binding.autonomy.text.toString().toFloat() != 0f
                && binding.autonomy.text.toString()
            .toFloat() != 0f) //Retorna true caso esta condição seja verdadeira, tudo precisa ser diferente de vazio / zero
    }

    fun calculateFun() {
        if (validate()) { //Se a validade retornar true
            val distance = binding.distance.text.toString().toFloat()// Modificando para float
            val price = binding.price.text.toString().toFloat()
            val autonomy = binding.autonomy.text.toString().toFloat()

            val totalPrice = (distance * price / autonomy)
            var totalPriceFormated = "R$ ${"%.2f".format(totalPrice)}" //Preço total formatado
            binding.totalPrice.text =
                totalPriceFormated //Transforma o texto em um formatado com preço total
            Toast.makeText(this, "Calculado :), $totalPriceFormated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.fill_all, Toast.LENGTH_SHORT).show()
        }

    }

    fun clearFun() {
        binding.distance.text.clear()
        binding.autonomy.text.clear()
        binding.price.text.clear()
        binding.totalPrice.text = "0"
        Toast.makeText(this, "Limpo :)", Toast.LENGTH_SHORT).show()
    }


}

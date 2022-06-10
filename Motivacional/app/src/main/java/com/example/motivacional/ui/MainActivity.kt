package com.example.motivacional.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.motivacional.Mock
import com.example.motivacional.R
import com.example.motivacional.SecurityPreferences
import com.example.motivacional.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater) //MainBinding
        setContentView(binding.root) //Change content view

        hideActionBar()
        exibition()

        binding.buttonPhrase.setOnClickListener(this) //Instance view onclickListener
        binding.imageAndroid.setOnClickListener(this) //Clicks images
        binding.imageHappy.setOnClickListener(this)
        binding.imageHome.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_phrase){
            newPhrase()
        }
        else if (v.id in listOf(R.id.image_android, R.id.image_happy, R.id.image_home)){
            handleFilter(v.id)
        }
    }

    private fun exibition(){
        val name = SecurityPreferences(this).getString("USER_NAME")
        val age = SecurityPreferences(this).getAge("AGE")
        binding.textName.text = "Olá, $name"
        binding.textFinalAge.text = "Você tem $age anos :)"
    }

    private fun hideActionBar(){
        supportActionBar?.hide()//hide action bar if is different from null
    }

    private fun handleFilter(id: Int){
        binding.imageHome.setColorFilter(ContextCompat.getColor(this,R.color.black)) //Para a cor não bugar
        binding.imageAndroid.setColorFilter(ContextCompat.getColor(this,R.color.black))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this,R.color.black))

        if(id == R.id.image_home){
            binding.imageHome.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = 1 //magic number
        }
        else if(id == R.id.image_android){
            binding.imageAndroid.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = 2

        }
        else if(id == R.id.image_happy){
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = 3
        }

    }

    fun newPhrase(){
        if(categoryId != 0){


        var newPhrase = Mock().getPhrase(categoryId)
        text_phrase.text = newPhrase
        }

        else {
            Toast.makeText(this, R.string.oops, Toast.LENGTH_SHORT).show()
        }
    }

}
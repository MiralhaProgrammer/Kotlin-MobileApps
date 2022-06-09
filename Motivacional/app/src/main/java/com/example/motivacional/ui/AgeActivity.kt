package com.example.motivacional.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.motivacional.R
import com.example.motivacional.SecurityPreferences
import com.example.motivacional.databinding.ActivityAgeBinding
import kotlinx.android.synthetic.main.activity_age.*


class AgeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding3: ActivityAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding3 = ActivityAgeBinding.inflate(layoutInflater)
        setContentView(binding3.root)

        verifyAge()
        binding3.buttonSave1.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save1) {
            val age = text_age.text.toString()
            if (age != "") {
                val security = SecurityPreferences(this)
                security.storeAge("AGE", age)
                startActivity(Intent(this,UserActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,R.string.validation_mandatory_age,Toast.LENGTH_SHORT).show()}
        }
    }

    fun verifyAge(){
        val age = SecurityPreferences(this).getAge("AGE")
        if(age != ""){
            startActivity(Intent(this, UserActivity::class.java)) //Começar a outra activity
            finish() //Encerrar a activity
        }

    }
}
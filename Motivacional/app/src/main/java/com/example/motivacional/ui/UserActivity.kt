package com.example.motivacional.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.motivacional.R
import com.example.motivacional.SecurityPreferences
import com.example.motivacional.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding2: ActivityUserBinding //Binding do usuário
    override fun onCreate(savedInstanceState: Bundle?) {
        binding2 = ActivityUserBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)

        supportActionBar?.hide()
        verifyUserName()
        binding2.buttonSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() { //Função para verificar o salvamento
        val name = binding2.editName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString("USER_NAME", name)

            startActivity(Intent(this, MainActivity::class.java)) //Começar a outra activity
            finish() //Encerrar a activity
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyUserName(){ //Verificar se já possui algum dado no sharedPreferences
        val name = SecurityPreferences(this).getString("USER_NAME")
        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java)) //Começar a outra activity
            finish() //Encerrar a activity
        }
    }
}
package com.example.constraintlayoutrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.constraintlayoutrecipes.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageLike.setOnClickListener(this)
        binding.imageDislike.setOnClickListener(this)
        binding.switch1.setOnClickListener(this)
        binding.buttonClear.setOnClickListener(this)

        exibition()

    }

    override fun onClick(v: View) {
        val randomNumber = (0..1).random()
        when (v.id) {
            R.id.image_like -> {
                likeClick()
            }

            R.id.image_dislike -> {
                dislikeClick()
            }

            R.id.switch_1 -> {
                if (switch_1.isChecked) {
                    switch1Checked()
                } else {
                    switch1Else()
                }
            }

            R.id.button_clear -> {
                clearData()
            }
        }

    }

    private fun clearData() {
        val secutiry = SecutiryPreferences(this)
        secutiry.storeLike("LIKE", "NENHUM")
        secutiry.storeIcon("ICON", "NÃO")

        image_like.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        image_dislike.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        text_rate_2.text = getString(R.string.rate_2)
        image_time.setImageResource(R.drawable.ic_time)
        image_calories.setImageResource(R.drawable.ic_calories)
        image_arrow_1.setImageResource(R.drawable.ic_arrow_right_24)
        image_arrow_2.setImageResource(R.drawable.ic_arrow_right_24)
        image_arrow_3.setImageResource(R.drawable.ic_arrow_right_24)
        switch_1.isChecked = false

    }

    private fun switch1Checked() {
        val security = SecutiryPreferences(this)
        security.storeIcon("ICON", "SIM")
        image_time.setImageResource(R.drawable.ic_time_2)
        image_calories.setImageResource(R.drawable.ic_calories_2)
        image_arrow_1.setImageResource(R.drawable.ic_arrow_left_24)
        image_arrow_2.setImageResource(R.drawable.ic_arrow_left_24)
        image_arrow_3.setImageResource(R.drawable.ic_arrow_left_24)
    }

    private fun switch1Else() {
        val security = SecutiryPreferences(this)
        security.storeIcon("ICON", "NÃO")
        image_time.setImageResource(R.drawable.ic_time)
        image_calories.setImageResource(R.drawable.ic_calories)
        image_arrow_1.setImageResource(R.drawable.ic_arrow_right_24)
        image_arrow_2.setImageResource(R.drawable.ic_arrow_right_24)
        image_arrow_3.setImageResource(R.drawable.ic_arrow_right_24)
    }

    private fun likeClick() {
        val security = SecutiryPreferences(this)
        security.storeLike("LIKE", "SIM")
        image_like.setColorFilter(ContextCompat.getColor(this, R.color.green))
        image_dislike.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        text_rate_2.text = getString(R.string.like)
    }

    private fun dislikeClick() {
        val secutiry = SecutiryPreferences(this)
        secutiry.storeLike("LIKE", "NÃO")
        image_like.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        image_dislike.setColorFilter(ContextCompat.getColor(this, R.color.red))
        text_rate_2.text = getString(R.string.dislike)
    }

    fun exibition() {
        val like = SecutiryPreferences(this).getStoreLike("LIKE")
        if (like == "SIM") {
            likeClick()
        } else if (like == "NÃO") {
            dislikeClick()
        } else if (like == "NENHUM") {
            image_like.setColorFilter(ContextCompat.getColor(this, R.color.gray))
            image_dislike.setColorFilter(ContextCompat.getColor(this, R.color.gray))
            text_rate_2.text = getString(R.string.rate_2)
        }
        val icon = SecutiryPreferences(this).getStoreIcon("ICON")
        if (icon == "SIM") {
            switch_1.setOnCheckedChangeListener(null)
            switch_1.isChecked = true
            switch1Checked()
        } else if (icon == "NÃO") {
            switch_1.isChecked = false
            switch1Else()
        }
    }

}
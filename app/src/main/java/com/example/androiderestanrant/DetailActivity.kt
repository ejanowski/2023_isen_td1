package com.example.androiderestanrant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiderestanrant.databinding.ActivityDetailBinding
import com.example.androiderestanrant.network.Plate

class DetailActivity : AppCompatActivity() {

    companion object {
        val PLATE_EXTRA = "PLATE_EXTRA"
    }

    lateinit var binding: ActivityDetailBinding
    var plate: Plate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plate = intent.getSerializableExtra(PLATE_EXTRA) as? Plate

        val ingredients = plate?.ingredients?.map { it.name }?.joinToString(", ") ?: ""
        binding.textView.text = ingredients

        plate?.let {
            binding.viewPager2.adapter = PhotoAdapter(it.images, this)
        }
    }
}
package com.ohyeah5566.transition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ohyeah5566.transition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnFragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        binding.btnActivity.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}
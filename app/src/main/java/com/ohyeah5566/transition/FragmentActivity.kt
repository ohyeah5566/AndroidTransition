package com.ohyeah5566.transition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportActionBar?.title = "FragmentActivity"
    }
}
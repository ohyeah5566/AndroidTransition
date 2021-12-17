package com.ohyeah5566.transition

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.ohyeah5566.transition.databinding.ListFragmentBinding
import com.ohyeah5566.transition.databinding.ProfileFragmentBinding

class ProfileActivity : AppCompatActivity() {

    val binding by lazy {
        ProfileFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = "ProfileActivity"

        val item = intent.getParcelableExtra<Item>("item")!!
        with(binding) {
            Log.d("ProfileActivity", item.name)
            tvName.text = item.name
            tvDesc.text = item.desc
            imageView.setBackgroundColor(
                ContextCompat.getColor(
                    this@ProfileActivity,
                    item.color
                )
            )

            tvName.transitionName = item.name//textView 如果名稱只是name 會有問題 怪怪的
            tvDesc.transitionName = item.desc
            imageView.transitionName = item.color.toString()
        }

    }
}
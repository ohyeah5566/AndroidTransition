package com.ohyeah5566.transition

import android.os.Bundle
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
        binding.item.root.transitionName = item.name
        binding.item.name.text = item.name
        binding.item.description.text = item.desc
        binding.item.imageView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                item.color
            )
        )
    }
}
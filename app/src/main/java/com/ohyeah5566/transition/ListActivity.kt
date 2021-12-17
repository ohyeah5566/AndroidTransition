package com.ohyeah5566.transition

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import com.ohyeah5566.transition.databinding.ListFragmentBinding

class ListActivity : AppCompatActivity() {

    private val binding by lazy {
        ListFragmentBinding.inflate(layoutInflater)
    }
    private val listItem by lazy {
        listOf(
            binding.item1,
            binding.item2,
            binding.item3
        )
    }
    private val items = listOf(
        Item("name1", "desc 1 more desc", android.R.color.holo_green_dark),
        Item("name2", "desc 2 more desc more desc", android.R.color.holo_blue_dark),
        Item("name3", "desc 3 more desc more desc more desc", android.R.color.holo_red_dark)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        for (i in 0..2) {
            val item = items[i]
            with(listItem[i]) {
                name.text = item.name
                description.text = item.desc
                imageView.setBackgroundColor(
                    ContextCompat.getColor(
                        this@ListActivity,
                        item.color
                    )
                )
                root.setOnClickListener {
                    root.transitionName = item.name
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@ListActivity,
                        root,
                        item.name
                    )
                    val intent = Intent(this@ListActivity, ProfileActivity::class.java)
                    intent.putExtra("item", item)
                    startActivity(intent, options.toBundle())
                }
            }
        }
    }
}
package com.ohyeah5566.transition

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.ohyeah5566.transition.databinding.ListFragmentBinding

class ListFragment : Fragment() {

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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (i in 0..2) {
            val item = items[i]
            with(listItem[i]) {
                name.text = item.name
                description.text = item.desc
                imageView.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        item.color
                    )
                )
                root.setOnClickListener {
                    root.transitionName = item.name
                    val extras = FragmentNavigatorExtras(
                        root to item.name
//                        name to item.name 有重複會crash
                    )
                    findNavController().navigate(
                        ListFragmentDirections.showUser(item), extras
                    )
                }
            }

        }
    }
}

data class Item(
    val name: String = "name",
    val desc: String = "desc",
    val color: Int = R.color.black
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeInt(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}
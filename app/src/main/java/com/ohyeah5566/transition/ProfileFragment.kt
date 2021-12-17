package com.ohyeah5566.transition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.ohyeah5566.transition.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {
    private val params by navArgs<ProfileFragmentArgs>()

    val binding by lazy {
        ProfileFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item.root.transitionName = params.item.name //綁定前一樣相同的transitionName
        binding.item.name.text = params.item.name
        binding.item.description.text = params.item.desc
        binding.item.imageView.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                params.item.color
            )
        )
    }
}
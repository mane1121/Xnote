package com.example.xnote.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.example.xnote.databinding.FragmentViewPhotoBinding

class ViewPhotoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPhotoBinding.inflate(layoutInflater)

        binding.viewPhoto.setImageURI(arguments?.getString("path").toString().toUri())
        binding.descriptionVP.setText(arguments?.getString("description"))
        binding.descriptionVP.isEnabled = false

        return binding.root
    }

}
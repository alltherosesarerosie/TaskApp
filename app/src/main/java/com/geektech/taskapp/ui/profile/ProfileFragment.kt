package com.geektech.taskapp.ui.profile

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.taskapp.R
import com.geektech.taskapp.data.Pref
import com.geektech.taskapp.databinding.FragmentProfileBinding
import com.geektech.taskapp.util.loadImage

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref
    private lateinit var image: String
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){
            uri: Uri? ->
        image = uri.toString()
//        binding.img.loadImage(image)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        binding.apply {
            etName.setText(pref.getName())
            etAge.setText(pref.getAge())
            profileImg.loadImage(pref.getImage())
        }
        binding.img.setOnClickListener {
            getContent.launch("image/*")
        }
        binding.save.setOnClickListener {
            pref.saveName(binding.etName.text.toString())
            pref.saveAge(binding.etAge.text.toString())
            pref.saveImage(image)
        }
    }
}
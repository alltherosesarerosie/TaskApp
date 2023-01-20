package com.geektech.taskapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.geektech.taskapp.R
import com.geektech.taskapp.model.Task
import com.geektech.taskapp.databinding.FragmentHomeBinding
import com.geektech.taskapp.ui.home.adapter.TaskAdapter
import com.geektech.taskapp.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapterr:TaskAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapterr= TaskAdapter()
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(TaskFragment.RESULT_TASK){key, bundle ->
            val result=bundle.getSerializable("task") as Task
            adapterr.addTask(result)
        }

        binding.recycleView.adapter= adapterr
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
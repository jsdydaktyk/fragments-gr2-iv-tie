package com.example.myfragments.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myfragments.R
import com.example.myfragments.adapters.ImagesGridAdapter
import com.example.myfragments.viewmodel.SharedViewModel


class ArrowFragment : Fragment(){

    private val viewModel: SharedViewModel by activityViewModels()
    private val listOfFruits = listOf(
        R.drawable.test_apple,
        R.drawable.test_banana,
        R.drawable.test_lemon,
        R.drawable.test_strawberry,
        R.drawable.test_watermelon
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_arrow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.textview_msg)

        // OBSERWOWANIE ZMIAN
        viewModel.selectedMessage.observe(viewLifecycleOwner) { message ->
            textView.text = message
        }

        val gridView: GridView = view.findViewById(R.id.gridView)
        gridView.adapter=ImagesGridAdapter(requireContext(), listOfFruits)
    }
}
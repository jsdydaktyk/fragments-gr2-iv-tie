package com.example.myfragments.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myfragments.R
import com.example.myfragments.viewmodel.SharedViewModel

class ContactFragment : Fragment(){


    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myEditText = view.findViewById<EditText>(R.id.edittext_msg)
        val myButton = view.findViewById<Button>(R.id.btn_sender)

        myButton.setOnClickListener {
            viewModel.setMessage(myEditText.text.toString())

        }
    }
}
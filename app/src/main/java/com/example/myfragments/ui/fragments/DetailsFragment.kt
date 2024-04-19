package com.example.myfragments.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.myfragments.R

class DetailsFragment : Fragment() {

    //DetailsFragment.newInstance()
    companion object {
        fun newInstance(imageId: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt("imageId", imageId)
                }
            }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        arguments?.let {
////            param1 = it.getString(ARG_PARAM1)
////            param2 = it.getString(ARG_PARAM2)
////        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_details, container, false)

        // Inflate the layout for this fragment
        val imageView: ImageView = view.findViewById(R.id.imageView_details)
        val imageId = arguments?.getInt("imageId") ?: R.drawable.baseline_home_24
        imageView.setImageResource(imageId)

       return view
    }


}
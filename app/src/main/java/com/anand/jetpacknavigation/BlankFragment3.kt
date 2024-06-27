package com.anand.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.anand.jetpacknavigation.databinding.FragmentBlank3Binding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment3 : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentBlank3Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank3Binding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnSetPass?.setOnClickListener {
            if (binding?.etPassword?.toString()?.equals(binding?.etRePassword?.toString()) == true) {
                Toast.makeText(requireContext(),"Password Changed",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(),"Password don't match",Toast.LENGTH_LONG).show()
            }

        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
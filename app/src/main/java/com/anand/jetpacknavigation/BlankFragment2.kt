package com.anand.jetpacknavigation

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.anand.jetpacknavigation.databinding.FragmentBlank2Binding


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment2 : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentBlank2Binding? = null
    var email = ""
    var num1 = ""
    var num2 = ""
    var num3 = ""
    var num4 = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            email = it.getString("email")?:""
            num1 = it.getString("num1")?:""
            num2 = it.getString("num2")?:""
            num3 = it.getString("num3")?:""
            num4 = it.getString("num4")?:""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.tvemail?.text = email
        binding?.moveTof1?.setOnClickListener {
            findNavController().popBackStack(R.id.blankFragment2,true)
        }

        binding?.et1?.doOnTextChanged{_,_,_,_->
           var otp1 = binding?.et1?.text.toString()?:""
            if(otp1.length==1){
                binding?.et2?.requestFocus()
            }
        }
        binding?.et2?.doOnTextChanged{_,_,_,_->
            var otp2 = binding?.et2?.text?.toString()?:""
            if(otp2.length==1){
                binding?.et3?.requestFocus()
            }
        }
        binding?.et3?.doOnTextChanged{_,_,_,_->
            var otp3 = binding?.et2?.text?.toString()?:""
            if(otp3.length==1){
                binding?.et4?.requestFocus()
            }
        }

        binding?.submit?.setOnClickListener {
            var enteredOTP = binding?.et1?.toString() + binding?.et2.toString() + binding?.et3?.toString() + binding?.et4?.toString()
            var generatedOTP = (num1+num2+num3+num4).toString()
            if(enteredOTP.equals(generatedOTP)==true){
                Dialog(requireContext()).apply {
                    setContentView(R.layout.customdialog)
                    window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
                    show()
                }

                }else{
                    Dialog(requireContext()).apply {
                        setContentView(R.layout.sorrydialogbox)
                        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
                        show()
                    }


            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}



package com.anand.jetpacknavigation

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
            email = it.getInt("email").toString()
            num1 = it.getInt("num1").toString()
            num2 = it.getInt("num2").toString()
            num3 = it.getInt("num3").toString()
            num4 = it.getInt("num4").toString()
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
        binding?.btnmoveToF3?.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment2_to_blankFragment3)
        }
        binding?.et1?.doOnTextChanged{_,_,_,_->
           var otp1 = binding?.et1?.text.toString()
            if(otp1.length ==1){
                binding?.et2?.requestFocus()
            }
        }
        binding?.et2?.doOnTextChanged{_,_,_,_->
            var otp2 = binding?.et2?.text?.toString()
            if(otp2?.length==1){
                binding?.et3?.requestFocus()
            }
        }
        binding?.et3?.doOnTextChanged{_,_,_,_->
            var otp3 = binding?.et2?.text?.toString()
            if(otp3?.length==1){
                binding?.et4?.requestFocus()
            }
        }


        binding?.submit?.setOnClickListener {
            var otp1 = binding?.et1?.toString()?.toInt()
            var otp2 = binding?.et2?.toString()?.toInt()
            val otp3 = binding?.et3.toString().toInt()
            var otp4 = binding?.et4?.toString()?.toInt()

            if((otp1== num1.toInt() &&otp2 == num2.toInt() &&otp3== num3.toInt() &&otp4== num4.toInt())==true){
                Dialog(requireContext()).apply {
                    setContentView(R.layout.customdialog)
                    window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
                    show()
                    var setNew = findViewById<Button>(R.id.btnSetNew)
                    setNew.setOnClickListener {
                        findNavController().navigate(R.id.blankFragment3)
                    }
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



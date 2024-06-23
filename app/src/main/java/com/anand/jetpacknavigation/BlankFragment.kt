package com.anand.jetpacknavigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.anand.jetpacknavigation.databinding.FragmentBlankBinding
import java.util.regex.Pattern
import kotlin.random.Random
import kotlin.random.nextInt


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentBlankBinding? = null
    val email = ""
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"


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
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.moveTof2?.setOnClickListener {
            if (binding?.etemail?.text?.toString().isNullOrEmpty()){
                binding?.etemail?.error = "Enter an Email"
            }else if (isValidEmail(binding?.etemail?.text.toString())==false){
                Toast.makeText(requireContext(),"Enter Valid Email",Toast.LENGTH_LONG).show()
            }
            else{
                var rnum1 = Random.nextInt(0..9)
                var rnum2 = Random.nextInt(0..9)
                var rnum3 = Random.nextInt(0..9)
                var rnum4 = Random.nextInt(0..9)

                var bundle = Bundle()
                bundle.putString("email",binding?.etemail?.text?.toString())
                bundle.putInt("num1",rnum1)
                bundle.putInt("num2",rnum2)
                bundle.putInt("num3",rnum3)
                bundle.putInt("num4",rnum4)
                findNavController().navigate(R.id.blankFragment2,bundle)
                var intent = Intent(Intent.ACTION_SENDTO)
                intent.setData(Uri.parse("mailto:${binding?.etemail}"))
                intent.putExtra(Intent.EXTRA_TEXT,"$bundle")
                startActivity(Intent.createChooser(intent,"Send Email"))





            }









        }
    }
    fun isValidEmail(email: String): Boolean {
        return email.matches(emailRegex.toRegex())
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
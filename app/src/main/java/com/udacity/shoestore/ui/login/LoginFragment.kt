package com.udacity.shoestore.ui.login

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.ui.instructions.InstructionsFragmentDirections

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun navigateToWelcomeFragment() {
        val action = LoginFragmentDirections.actionLoginToWelcomeFragment()
        this.findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            navigateToWelcomeFragment()
        }

        binding.buttonRegister.setOnClickListener {
            navigateToWelcomeFragment()
        }
    }
}
package com.udacity.shoestore.ui.welcome

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.ui.shoelist.ShoeListFragmentDirections

class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonWelcome.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            this.findNavController().navigate(action)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.textviewWelcomeDescription.apply {
                this.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
            }

        }
    }
}
package com.udacity.shoestore.ui.shoelist

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.ui.MainActivityViewModel
import com.udacity.shoestore.ui.adapter.ShoeAdapter

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: MainActivityViewModel by viewModels()

    private val mAdapter: ShoeAdapter by lazy { ShoeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewShoes.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
            mAdapter.notifyDataSetChanged()
        }

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(viewModel.shoes.value?.asReversed())
            mAdapter.notifyDataSetChanged()
        })

        binding.fabAddShoe.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment()
            findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
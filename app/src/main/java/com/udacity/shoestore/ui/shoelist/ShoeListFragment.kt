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
import com.udacity.shoestore.data.models.Shoe
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.ui.MainActivityViewModel
import com.udacity.shoestore.ui.adapter.ShoeAdapter
import kotlinx.android.synthetic.main.item_shoe.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        binding.mainActivityViewModel = viewModel

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            viewModel.shoes.value?.asReversed()?.map {
                val itemShoeBinding = ItemShoeBinding.inflate(layoutInflater, binding.linearlayoutShoeList, false)
                val cardView = itemShoeBinding.cardviewShoeItem
                cardView.textview_shoe_name.text = it.name.capitalize()
                cardView.textview_shoe_company.text =  it.company
                cardView.textview_shoe_size.text = "Size: ${it.size}"
                cardView.textview_shoe_description.text = it.description
                binding.linearlayoutShoeList.addView(cardView)
            }
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
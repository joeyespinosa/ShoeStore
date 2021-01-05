package com.udacity.shoestore.ui

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.data.models.Shoe
import timber.log.Timber

class MainActivityViewModel: ViewModel(), Observable {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    private val _isShoeAdded = MutableLiveData<Boolean>()

    @Bindable
    val name = MutableLiveData<String>()
    @Bindable
    val company = MutableLiveData<String>()
    @Bindable
    val size = MutableLiveData<String>()
    @Bindable
    val description = MutableLiveData<String>()

    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes
    val isShoeAdded: LiveData<Boolean>
        get() = _isShoeAdded

    init {
        val shoeList = mutableListOf<Shoe>()
        _shoes.value = shoeList

        repeat(3) {
            _shoes.value?.add(
                Shoe(
                    name = "${getRandomShoeName() } ${it + 1}",
                    company = "Sample ${it + 1}",
                    description = "This is a test description${it + 1}",
                    size = (it + 1).toDouble()
                )
            )
        }

        _isShoeAdded.value = false
    }

    private fun getRandomShoeName() : String {
        val list = listOf<String>("Nike", "Adidas", "FILA")
        return list[(list.indices).random()]
    }

    fun addShoeItem() {
        val nameText = if (name.value!!.isEmpty()) "N/A" else  name.value!!
        val companyText = if (company.value!!.isEmpty()) "N/A" else  company.value!!
        val sizeText = if (size.value!!.isEmpty()) 0 else  size.value?.toDouble()!!
        val descriptionText = if (description.value!!.isEmpty()) "N/A" else  description.value!!

        _shoes.value?.add(Shoe(
            nameText,
            sizeText as Double,
            companyText,
            descriptionText))
        _isShoeAdded.value = true
    }

    fun shoeAddedComplete() {
        _isShoeAdded.value = false
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) { }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) { }
}
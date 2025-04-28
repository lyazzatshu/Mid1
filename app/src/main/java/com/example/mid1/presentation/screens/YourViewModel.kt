package com.example.mid1.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mid1.domain.model.YourEntity
import com.example.mid1.domain.usecase.GetAllItemsUseCase
import com.example.mid1.domain.usecase.InsertItemUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class YourViewModel(
    private val getAllItemsUseCase: GetAllItemsUseCase,
    private val insertItemUseCase: InsertItemUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<YourEntity>>(emptyList())
    val items: StateFlow<List<YourEntity>> = _items

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            val result = getAllItemsUseCase()
            _items.value = result
        }
    }

    fun addItem(name: String) {
        viewModelScope.launch {
            val newItem = YourEntity(name = name)
            insertItemUseCase(newItem)
            loadItems()
        }
    }
}

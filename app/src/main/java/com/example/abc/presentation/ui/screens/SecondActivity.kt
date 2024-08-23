package com.example.abc.presentation.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.abc.data.source.CustomItemDataSource
import com.example.abc.domain.repository.CustomItemRepository
import com.example.abc.presentation.ui.components.MainContent
import com.example.abc.presentation.viewmodel.CustomItemViewModel
import com.example.abc.presentation.viewmodel.CustomItemViewModelFactory

class SecondActivity : ComponentActivity() {

    private lateinit var viewModel: CustomItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeViewModel()
        setContent {
            MainContent(viewModel)
        }

        viewModel.fetchCustomItems()
    }

    private fun initializeViewModel() {
        val factory = CustomItemViewModelFactory(CustomItemRepository(CustomItemDataSource()))
        viewModel = ViewModelProvider(this, factory)[CustomItemViewModel::class.java]
    }
}



















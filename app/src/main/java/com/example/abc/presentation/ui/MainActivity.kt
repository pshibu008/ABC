package com.example.abc.presentation.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.abc.R
import com.example.abc.data.source.CustomItemDataSource
import com.example.abc.domain.model.CustomItem
import com.example.abc.domain.model.Item
import com.example.abc.data.repository.CustomItemRepositoryImpl
import com.example.abc.domain.usecase.FilterItemsUseCase
import com.example.abc.domain.usecase.TopThreeFrequentCharactersUseCase
import com.example.abc.presentation.adapter.CarouselViewPagerAdapter
import com.example.abc.presentation.adapter.ItemListAdapter
import com.example.abc.presentation.viewmodel.CustomItemViewModel
import com.example.abc.presentation.viewmodel.CustomItemViewModelFactory
import com.example.abc.presentation.ui.state.UiState
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemListAdapter: ItemListAdapter
    private lateinit var viewModel: CustomItemViewModel
    private lateinit var searchView: SearchView
    private lateinit var nestedScrollView: NestedScrollView
    private var fullItemList: List<Item> = emptyList()
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupViewModel()
        setupSearchView()
        setupViewPager()
        setupFabButton()
        setupTabLayout()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search_view)
        nestedScrollView = findViewById(R.id.nested_scroll_view)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupTabLayout() {
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT)
        nestedScrollView.viewTreeObserver.addOnScrollChangedListener {
            adjustSearchViewPosition()
        }
    }

    private fun adjustSearchViewPosition() {
        val scrollY = nestedScrollView.scrollY
        val searchViewTop = searchView.top
        searchView.translationY = if (scrollY >= searchViewTop) (scrollY - searchViewTop).toFloat() else 0f
    }

    private fun setupViewModel() {
        val filterItemsUseCase = FilterItemsUseCase()
        val topThreeFrequentCharactersUseCase = TopThreeFrequentCharactersUseCase()
        val repository = CustomItemRepositoryImpl(CustomItemDataSource())
        val factory = CustomItemViewModelFactory(filterItemsUseCase, topThreeFrequentCharactersUseCase, repository)

        viewModel = ViewModelProvider(this, factory)[CustomItemViewModel::class.java]

        lifecycleScope.launch {
            viewModel.customItemsState.collect { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        progressBar.visibility = View.VISIBLE
                        nestedScrollView.visibility = View.GONE
                    }
                    is UiState.Success -> {
                        progressBar.visibility = View.GONE
                        nestedScrollView.visibility = View.VISIBLE
                        val customItems = uiState.data
                        fullItemList = customItems[0].list
                        setupCarousel(customItems)
                        setupRecyclerView(fullItemList)
                    }
                    is UiState.Error -> {
                        progressBar.visibility = View.GONE
                        nestedScrollView.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, uiState.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }


    private fun setupCarousel(customItems: List<CustomItem>) {
        val viewPagerAdapter = CarouselViewPagerAdapter(customItems) { position ->
            updateRecyclerView(customItems[position].list)
        }
        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(findViewById(R.id.tabLayout), viewPager) { tab, _ ->
            tab.customView = layoutInflater.inflate(R.layout.custom_tab, null)
        }.attach()
    }

    private fun setupRecyclerView(items: List<Item>) {
        itemListAdapter = ItemListAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemListAdapter
    }

    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterItems(fullItemList, newText)
                return true
            }
        })

        lifecycleScope.launch {
            viewModel.itemList.collect { filteredItems ->
                updateRecyclerView(filteredItems)
            }
        }
    }

    private fun setupViewPager() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val currentState = viewModel.customItemsState.value
                if (currentState is UiState.Success) {
                    val customItems = currentState.data
                    fullItemList = customItems[position].list
                    viewModel.filterItems(fullItemList, searchView.query.toString())
                }
            }
        })
    }


    private fun setupFabButton() {
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val topThreeCharacters = viewModel.getTopThreeFrequentCharacters(fullItemList)
            StatsBottomSheetDialog(this).show(topThreeCharacters)
        }
    }

    private fun updateRecyclerView(items: List<Item>) {
        if (::itemListAdapter.isInitialized) {
            itemListAdapter.updateItems(items)
        } else {
            setupRecyclerView(items)
        }
    }
}

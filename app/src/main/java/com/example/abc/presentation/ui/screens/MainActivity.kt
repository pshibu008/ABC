package com.example.abc.presentation.ui.screens

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.abc.R
import com.example.abc.data.source.CustomItemDataSource
import com.example.abc.domain.model.CustomItem
import com.example.abc.domain.model.Item
import com.example.abc.domain.repository.CustomItemRepository
import com.example.abc.presentation.adapter.CarouselViewPagerAdapter
import com.example.abc.presentation.adapter.ItemListAdapter
import com.example.abc.presentation.viewmodel.CustomItemViewModel
import com.example.abc.presentation.viewmodel.CustomItemViewModelFactory
import com.example.abc.util.CustomItemUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemListAdapter: ItemListAdapter
    private lateinit var viewModel: CustomItemViewModel
    private lateinit var searchView: SearchView
    private lateinit var nestedScrollView: NestedScrollView
    private var fullItemList: List<Item> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupTabLayout()
        setupViewModel()
        setupSearchView()
        setupViewPager()
        setupFabButton()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search_view)
        nestedScrollView = findViewById(R.id.nested_scroll_view)
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
        val factory = CustomItemViewModelFactory(CustomItemRepository(CustomItemDataSource()))
        viewModel = ViewModelProvider(this, factory)[CustomItemViewModel::class.java]

        viewModel.customItems.observe(this) { customItems ->
            if (customItems.isNotEmpty()) {
                setupCarousel(customItems)
                setupRecyclerView(customItems[0].list)
            }
        }
        viewModel.fetchCustomItems()
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
                val filteredList = CustomItemUtils.filterList(fullItemList, newText)
                updateRecyclerView(filteredList)
                return true
            }
        })
    }

    private fun setupViewPager() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.customItems.value?.let {
                    fullItemList = it[position].list
                    val filteredList = CustomItemUtils.filterList(fullItemList, searchView.query.toString())
                    updateRecyclerView(filteredList)
                }
            }
        })
    }

    private fun setupFabButton() {
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            StatsBottomSheetDialog(this).show(fullItemList)
        }
    }

    private fun updateRecyclerView(items: List<Item>) {
        itemListAdapter.updateItems(items)
    }

}

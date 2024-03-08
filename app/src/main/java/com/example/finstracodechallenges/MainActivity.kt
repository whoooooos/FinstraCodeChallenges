package com.example.finstracodechallenges

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finstracodechallenges.adapter.ImagesAdapter
import com.example.finstracodechallenges.databinding.ActivityMainBinding
import com.example.sampleproject.viewmodel.ImageViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mAdapter: ImagesAdapter? = null
    private val viewModel: ImageViewModel by lazy {
        ViewModelProviders.of(this)[ImageViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // observe changes on viewModel data
        viewModel.randomImages.observe(this) { response ->
            if (response == null) {
                return@observe
            }
            mAdapter = ImagesAdapter(this, response)
            val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
            binding.recyclerView.layoutManager = linearLayoutManager
            binding.recyclerView.adapter = mAdapter
            // set isRefreshing to false once the data become available
            binding.swipe.isRefreshing = false
        }

        // handle re-fetching of images on swipe
        binding.swipe.setOnRefreshListener {
            viewModel.refreshImages()
        }
    }
}
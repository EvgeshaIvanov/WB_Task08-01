package com.example.dota2wiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2wiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var heroesAdapter: HeroesAdapter


    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getHeroes(FULL_URL)
        viewModel.heroDataList.observe(this) {
            heroesAdapter.heroesList = it
        }

    }
    private fun setupRecyclerView() {
        heroesAdapter = HeroesAdapter()
        binding.rvHeroes.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = heroesAdapter
        }
    }

    companion object {
        const val BASE_URL = "https://api.opendota.com"
        const val FULL_URL = "https://api.opendota.com/api/heroStats"
    }

}
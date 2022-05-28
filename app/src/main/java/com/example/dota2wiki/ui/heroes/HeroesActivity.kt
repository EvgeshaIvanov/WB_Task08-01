package com.example.dota2wiki.ui.heroes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dota2wiki.databinding.ActivityHeroesAllBinding
import com.example.dota2wiki.ui.detailHero.DetailHeroActivity


class HeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesAllBinding

    private lateinit var heroesAdapter: HeroesAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesAllBinding.inflate(layoutInflater)
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
            layoutManager = GridLayoutManager(this@HeroesActivity, 2)
            adapter = heroesAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        heroesAdapter.onHeroClickLister = {
            val intent = Intent(this, DetailHeroActivity::class.java)
            intent.putExtra(HERO_DATA, it)
            startActivity(intent)
        }
    }


    companion object {
        const val HERO_DATA = "HERO_DATA"
        const val BASE_URL = "https://api.opendota.com"
        const val FULL_URL = "https://api.opendota.com/api/heroStats"
    }

}
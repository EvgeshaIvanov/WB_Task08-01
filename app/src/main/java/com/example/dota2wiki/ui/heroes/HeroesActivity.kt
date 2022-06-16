package com.example.dota2wiki.ui.heroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.dota2wiki.R
import com.example.dota2wiki.databinding.ActivityHeroesBinding
import com.example.dota2wiki.ui.aboutApp.AboutFragment
import com.example.dota2wiki.ui.detailHero.HeroesListFragment


class HeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.aboutBtn.setOnClickListener { openFragment(AboutFragment()) }

        openFragment(HeroesListFragment())
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }


}
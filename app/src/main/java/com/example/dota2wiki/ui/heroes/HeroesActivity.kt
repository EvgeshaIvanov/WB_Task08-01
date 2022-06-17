package com.example.dota2wiki.ui.heroes

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.dota2wiki.R
import com.example.dota2wiki.databinding.ActivityHeroesBinding
import com.example.dota2wiki.ui.aboutApp.AboutFragment


class HeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.aboutBtn.setOnClickListener {
            openFragment(AboutFragment(), STACK_NAME)
        }
        openFragment(HeroesListFragment(), null)
    }

    private fun openFragment(fragment: Fragment, stackName: String?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment)
            .addToBackStack(stackName)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    companion object {
        const val STACK_NAME = "STACK_NAME"
    }

}
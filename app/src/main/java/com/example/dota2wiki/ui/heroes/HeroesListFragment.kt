package com.example.dota2wiki.ui.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dota2wiki.R
import com.example.dota2wiki.databinding.FragmentHeroesListBinding
import com.example.dota2wiki.ui.detailHero.DetailHeroFragment


class HeroesListFragment : Fragment() {

    private lateinit var binding: FragmentHeroesListBinding

    private lateinit var heroesAdapter: HeroesAdapter

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        viewModel.getHeroesDataFromStorage(FULL_URL)
        viewModel.heroDataList.observe(viewLifecycleOwner) {
            heroesAdapter.heroesList = it
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        heroesAdapter = HeroesAdapter()
        binding.rvHeroes.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = heroesAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        heroesAdapter.onHeroClickLister = { hero ->
            val detailHeroFragment = DetailHeroFragment()
            val bundle = Bundle().apply { putParcelable(HERO_DATA, hero) }
            detailHeroFragment.arguments = bundle
            openFragment(detailHeroFragment)
        }
    }

    private fun openFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    companion object {
        const val HERO_DATA = "HERO_DATA"
        const val BASE_URL = "https://api.opendota.com"
        const val FULL_URL = "https://api.opendota.com/api/heroStats"
    }

}
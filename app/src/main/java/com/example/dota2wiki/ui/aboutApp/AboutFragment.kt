package com.example.dota2wiki.ui.aboutApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dota2wiki.R
import com.example.dota2wiki.databinding.FragmentAboutBinding
import com.example.dota2wiki.ui.heroes.HeroesActivity.Companion.STACK_NAME
import com.example.dota2wiki.ui.heroes.HeroesListFragment


class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.popBackStack(STACK_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        return binding.root
    }
}
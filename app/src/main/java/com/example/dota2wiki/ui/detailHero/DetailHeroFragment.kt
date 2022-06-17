package com.example.dota2wiki.ui.detailHero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import coil.load
import com.example.dota2wiki.data.HeroData
import com.example.dota2wiki.databinding.FragmentDetailHeroBinding
import com.example.dota2wiki.ui.heroes.HeroesListFragment.Companion.BASE_URL
import com.example.dota2wiki.ui.heroes.HeroesListFragment.Companion.HERO_DATA


class DetailHeroFragment : Fragment() {

    private lateinit var binding: FragmentDetailHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailHeroBinding.inflate(inflater, container, false)
        detailHeroInfo()
        return binding.root
    }

    private fun detailHeroInfo() {
        val hero = arguments?.getParcelable<HeroData>(HERO_DATA)!!
        binding.apply {
            heroAvatarImage.load(BASE_URL + hero.imageHero) {
                size(width = 300, 250)
                crossfade(250)
            }
            heroName.text = hero.name
            setAttribute(hero.primaryAttribute.toString())
            healthHeroInfo.text = hero.health
            manaHeroInfo.text = hero.mana
            setRanged(hero.attackType.toString())
            moveSpeedInfo.text = hero.moveSpeed
        }


    }

    private fun setAttribute(attribute: String) {
        val text: TextView = binding.primaryAttributeInfo
        when (attribute) {
            INT_ATTRIBUTE -> text.text = "Интеллект"
            AGI_ATTRIBUTE -> text.text = "Ловкость"
            STR_ATTRIBUTE -> text.text = "Сила"
        }
    }

    private fun setRanged(rangeType: String) {
        val text: TextView = binding.attackTypeInfo
        when (rangeType) {
            RANGED_TYPE_ATTACK -> text.text = "Дальний бой"
            MELEE_TYPE_ATTACK -> text.text = "Ближний бой"
        }
    }

    companion object {
        const val INT_ATTRIBUTE = "int"
        const val AGI_ATTRIBUTE = "agi"
        const val STR_ATTRIBUTE = "str"
        const val RANGED_TYPE_ATTACK = "Ranged"
        const val MELEE_TYPE_ATTACK = "Melee"
    }

}
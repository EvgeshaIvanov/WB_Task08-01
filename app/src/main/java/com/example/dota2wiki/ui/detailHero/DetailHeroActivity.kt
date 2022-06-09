package com.example.dota2wiki.ui.detailHero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import coil.load
import com.example.dota2wiki.databinding.ActivityDetailHeroBinding
import com.example.dota2wiki.data.HeroData
import com.example.dota2wiki.ui.heroes.HeroesActivity.Companion.BASE_URL
import com.example.dota2wiki.ui.heroes.HeroesActivity.Companion.HERO_DATA

class DetailHeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailHeroInfo()
    }

    private fun detailHeroInfo() {
        val hero = intent.getParcelableExtra<HeroData>(HERO_DATA)!!
        binding.apply {
            heroAvatarImage.load(BASE_URL + hero.imageHero){
                size(width = 300 , 250)
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
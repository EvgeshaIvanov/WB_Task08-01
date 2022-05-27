package com.example.dota2wiki

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dota2wiki.MainActivity.Companion.BASE_URL
import com.example.dota2wiki.model.HeroData

class HeroesAdapter : RecyclerView.Adapter<HeroesViewHolder>() {


    var heroesList = emptyList<HeroData>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val layout = when(viewType){
            VIEW_TYPE_AGILITY -> R.layout.item_list_agi
            VIEW_TYPE_INTELLECT -> R.layout.item_list_int
            VIEW_TYPE_STRENGTH -> R.layout.item_list_str
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return HeroesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val hero = heroesList[position]

        with(holder) {

            heroName.text = hero.name
            heroIconImage.load(BASE_URL + hero.iconHero)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val hero = heroesList[position]
        return when (hero.primary_attribute){
            AGILITY -> VIEW_TYPE_AGILITY
            STRENGTH -> VIEW_TYPE_STRENGTH
            INTELLECT -> VIEW_TYPE_INTELLECT
            else -> throw RuntimeException("Unknown attribute $this")
        }

    }

    override fun getItemCount(): Int = heroesList.size

    private fun String.setFormatToSearch(): String{
        return this.lowercase().replace(' ', '_')
    }
    companion object{
        const val VIEW_TYPE_AGILITY = 1
        const val VIEW_TYPE_STRENGTH = 2
        const val VIEW_TYPE_INTELLECT = 3
        const val AGILITY = "agi"
        const val STRENGTH = "str"
        const val INTELLECT = "int"
    }
}
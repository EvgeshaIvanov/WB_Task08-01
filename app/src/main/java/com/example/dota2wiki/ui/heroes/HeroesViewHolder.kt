package com.example.dota2wiki.ui.heroes

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2wiki.R

class HeroesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val heroCard: CardView = view.findViewById(R.id.hero_card_view)
    val heroName: TextView = view.findViewById(R.id.hero_name)
    val heroIconImage: ImageView = view.findViewById(R.id.hero_icon_image)

}
package com.example.dota2wiki

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeroesViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    val heroName: TextView = view.findViewById(R.id.hero_name)

    val heroIconImage: ImageView = view.findViewById(R.id.hero_icon_image)

}
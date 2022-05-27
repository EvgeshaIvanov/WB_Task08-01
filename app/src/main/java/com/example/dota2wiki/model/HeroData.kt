package com.example.dota2wiki.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class HeroData(
    @Json(name = "id")
    val id: String,
    @Json(name = "localized_name")
    val name: String,
    @Json(name = "img")
    val imageHero: String,
    @Json(name = "icon")
    val iconHero: String,
    @Json(name = "primary_attr")
    val primary_attribute: String
)

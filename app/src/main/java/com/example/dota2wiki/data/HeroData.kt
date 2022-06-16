package com.example.dota2wiki.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class HeroData(
    @Json(name = "id")
    val id: String?,
    @Json(name = "localized_name")
    val name: String?,
    @Json(name = "img")
    val imageHero: String?,
    @Json(name = "icon")
    val iconHero: String?,
    @Json(name = "primary_attr")
    val primaryAttribute: String?,
    @Json(name = "base_health")
    val health: String?,
    @Json(name = "base_mana")
    val mana: String?,
    @Json(name = "attack_type")
    val attackType: String?,
    @Json(name = "move_speed")
    val moveSpeed : String?
): Parcelable



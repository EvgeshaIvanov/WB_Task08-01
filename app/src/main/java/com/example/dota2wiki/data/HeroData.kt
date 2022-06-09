package com.example.dota2wiki.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


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
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(imageHero)
        parcel.writeString(iconHero)
        parcel.writeString(primaryAttribute)
        parcel.writeString(health)
        parcel.writeString(mana)
        parcel.writeString(attackType)
        parcel.writeString(moveSpeed)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroData> {
        override fun createFromParcel(parcel: Parcel): HeroData {
            return HeroData(parcel)
        }

        override fun newArray(size: Int): Array<HeroData?> {
            return arrayOfNulls(size)
        }
    }

}

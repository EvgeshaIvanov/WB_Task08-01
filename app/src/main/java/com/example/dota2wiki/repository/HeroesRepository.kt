package com.example.dota2wiki.repository

import com.example.dota2wiki.data.HeroData

interface HeroesRepository {

    fun saveHeroes(filename: String, text: String)

    fun readHeroesFromLocalData(filename: String): String

    fun readFromJson(response: String): List<HeroData>

    fun apiRequest(sUrl: String): String?

    fun isExistFileInLocalStorage(fileName: String): Boolean

}
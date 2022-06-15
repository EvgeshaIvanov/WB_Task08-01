package com.example.dota2wiki.repository

import com.example.dota2wiki.data.FileManager
import com.example.dota2wiki.data.HeroData
import com.example.dota2wiki.network.ApiService

class HeroesRepositoryImpl : HeroesRepository {

    private val fileManager = FileManager()

    private val getClient = ApiService()

    override fun saveHeroes(filename: String, text: String) {
        fileManager.writeToFile(filename, text)
    }

    override fun readHeroesFromLocalData(filename: String): String {
        return fileManager.readFromFile(filename)
    }

    override fun readFromJson(response: String): List<HeroData> {
        return fileManager.readJson(response)!!
    }

    override fun apiRequest(sUrl: String): String? {
        return getClient.getRequest(sUrl)
    }

    override fun isExistFileInLocalStorage(fileName: String): Boolean {
        return fileManager.isExistFileInLocalStorage(fileName)
    }
}
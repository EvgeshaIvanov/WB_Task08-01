package com.example.dota2wiki.ui.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2wiki.data.HeroData
import com.example.dota2wiki.repository.HeroesRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val FILE_NAME = "HeroesLocalData.txt"

class MainViewModel : ViewModel() {

    private val heroesRepositoryImpl = HeroesRepositoryImpl()

    val heroDataList = MutableLiveData<List<HeroData>>()

    fun getHeroesDataFromStorage(sUrl: String) {
        if (heroesRepositoryImpl.isExistFileInLocalStorage(FILE_NAME)) {
            getHeroFromLocalStorage()
        } else {
            getHeroesDataFromRemoteStorage(sUrl)
        }
    }

    private fun getHeroFromLocalStorage() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = heroesRepositoryImpl.readHeroesFromLocalData(FILE_NAME)
            val pes = heroesRepositoryImpl.readFromJson(list)
            heroDataList.postValue(pes)
        }
    }


    private fun getHeroesDataFromRemoteStorage(sUrl: String): List<HeroData>? {
        var heroData: List<HeroData>? = null
        viewModelScope.launch(Dispatchers.IO) {
            val response = heroesRepositoryImpl.apiRequest(sUrl)
            val result = response?.let { heroesRepositoryImpl.readFromJson(it) }
            if (result != null) {
                withContext(Dispatchers.Main) {
                    heroData = result
                    heroesRepositoryImpl.saveHeroes(FILE_NAME, response)
                    heroDataList.value = heroData!!
                }
            }
        }
        return heroData
    }


}
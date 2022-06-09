package com.example.dota2wiki.ui.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2wiki.data.FileManager
import com.example.dota2wiki.data.HeroData
import com.example.dota2wiki.network.RepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class MainViewModel : ViewModel() {

    private val fileManager = FileManager()

    val fileHeroData: File = File.createTempFile("HeroesDataStorage", ".txt")

    private var moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @OptIn(ExperimentalStdlibApi::class)
    private val jsonAdapter = moshi.adapter<MutableList<HeroData>>()

    val heroDataList = MutableLiveData<List<HeroData>>()

    fun getHeroes(sUrl: String): List<HeroData>? {
        var heroData: MutableList<HeroData>? = null
        viewModelScope.launch(Dispatchers.IO) {
            val result = RepositoryImpl.getRequest(sUrl)
            if (result != null) {
                try {
                    fileManager.writeToFile(fileHeroData, result)
                    val heroDataStorage = fileManager.readFromFile(fileHeroData)
                    heroData = if (heroDataStorage.isNotEmpty()) {
                        jsonAdapter.fromJson(heroDataStorage)
                    } else jsonAdapter.fromJson(result)
                    withContext(Dispatchers.Main) {
                        heroDataList.value = heroData!!
                    }
                } catch (err: Error) {
                    print("Error when parsing JSON: " + err.localizedMessage)
                }
            } else {
                print("Error: Get request returned no response")
            }
        }
        return heroData
    }

}
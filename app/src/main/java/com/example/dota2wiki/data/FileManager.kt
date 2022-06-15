package com.example.dota2wiki.data

import android.content.Context
import com.example.dota2wiki.MyApp
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class FileManager {

    fun isExistFileInLocalStorage(fileName: String): Boolean {
        val file = MyApp.getApplicationContext().getFileStreamPath(fileName)
        return file.exists()
    }

    fun writeToFile(fileName: String, text: String) {
        MyApp.getApplicationContext().openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(text.toByteArray())
        }
    }

    fun readFromFile(fileName: String): String {
        val text = MyApp.getApplicationContext().openFileInput(fileName).bufferedReader().use {
            it.readText()
        }
        return text
    }

    fun readJson(response: String): List<HeroData>? {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, HeroData::class.java)
        val jsonAdapter: JsonAdapter<List<HeroData>> = moshi.adapter(listType)
        return jsonAdapter.fromJson(response)
    }

}
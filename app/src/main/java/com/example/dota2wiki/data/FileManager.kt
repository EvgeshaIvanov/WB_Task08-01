package com.example.dota2wiki.data

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class FileManager() {

    fun writeToFile(file: File, text: String) {
        FileOutputStream(file).use {
            it.write(text.toByteArray())
        }
    }

    fun readFromFile(file: File): String {
        val text = FileInputStream(file).bufferedReader().use {
            it.readText()
        }
        return text
    }

}
package com.example.dota2wiki.network


interface ApiService {

    fun getRequest(sUrl: String): String?
}

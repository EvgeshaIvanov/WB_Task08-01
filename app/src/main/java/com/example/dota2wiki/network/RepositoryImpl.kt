package com.example.dota2wiki.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

object RepositoryImpl : ApiService {

    private var client: OkHttpClient = OkHttpClient()

    override fun getRequest(sUrl: String): String? {
        var result: String? = null
        try {
            val url = URL(sUrl)
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            result = response.body?.string()
            Log.i("Result from backend", response.toString())
        } catch (err: Error) {
            print("Error when executing get request: " + err.localizedMessage)
        }
        return result
    }


}

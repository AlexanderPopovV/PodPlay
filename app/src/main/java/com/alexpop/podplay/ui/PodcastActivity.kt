package com.alexpop.podplay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alexpop.podplay.R
import com.alexpop.podplay.repository.ItunesRepo
import com.alexpop.podplay.service.ItunesService
import com.alexpop.podplay.service.PodcastResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PodcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = javaClass.simpleName
        val itunesService = ItunesService.instance //getServiceInstance()
        val itunesRepo = ItunesRepo(itunesService)

        itunesRepo.searchByTerm("Android Developer", {
            Log.i(TAG, "Results = $it")
        })
    }
}

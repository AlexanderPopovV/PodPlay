package com.alexpop.podplay.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import com.alexpop.podplay.R
import com.alexpop.podplay.repository.ItunesRepo
import com.alexpop.podplay.service.ItunesService
import kotlinx.android.synthetic.main.activity_main.*
import com.alexpop.podplay.service.PodcastResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PodcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itunesService = ItunesService.instance //getServiceInstance()
        val itunesRepo = ItunesRepo(itunesService)

        setupToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)

        val searchMenuItem = menu.findItem(R.id.search_item)
        val searchView = searchMenuItem?.actionView as SearchView

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        return true
    }
    private fun performSearch(term: String){
        val TAG = javaClass.simpleName
        val itunesService = ItunesService.instance
        val itunesRepo = ItunesRepo(itunesService)
        itunesRepo.searchByTerm(term, {
            Log.i(TAG, "Results = $it")
        })
    }

    private fun handleIntent(intent: Intent){
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            performSearch(query)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
    }

}

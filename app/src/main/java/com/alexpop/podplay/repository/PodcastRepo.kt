package com.alexpop.podplay.repository

import com.alexpop.podplay.model.Podcast


class PodcastRepo {
     fun getPodcast(feedUrl: String, callback: (Podcast?) -> Unit) {
         callback(Podcast(feedUrl, "No Name", "No description", "No image"))
     }
 }
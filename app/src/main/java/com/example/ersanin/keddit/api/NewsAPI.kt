package com.example.ersanin.keddit.api

import retrofit2.Call

/**
 * Created by Ersanin on 24.06.2016.
 */
interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}
package com.example.ersanin.keddit.features

import com.example.ersanin.keddit.api.NewsAPI
import com.example.ersanin.keddit.api.RestAPI
import com.example.ersanin.keddit.common.RedditNews
import com.example.ersanin.keddit.common.RedditNewsItem
import rx.Observable

/**
 * Created by Ersanin on 23.06.2016.
 */
class NewsManager(private val api: NewsAPI = RestAPI()) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news)

                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}
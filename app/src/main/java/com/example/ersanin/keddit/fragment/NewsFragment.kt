@file:JvmName("ExtensionsUtils")

package com.example.ersanin.keddit.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ersanin.keddit.R
import com.example.ersanin.keddit.common.InfiniteScrollListener
import com.example.ersanin.keddit.common.RedditNews
import com.example.ersanin.keddit.common.RxBaseFragment
import com.example.ersanin.keddit.common.extensions.inflate
import com.example.ersanin.keddit.features.NewsManager
import com.example.ersanin.keddit.features.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Ersanin on 20.06.2016.
 */
class NewsFragment : RxBaseFragment() {

    private val newsManager by lazy { NewsManager() }
    private val newsList: RecyclerView by lazy { news_list }
    private var redditNews: RedditNews? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList.setHasFixedSize(true) // <-- Lazy executed!
        val linearLayout = LinearLayoutManager(context)
        news_list.layoutManager = linearLayout
        news_list.clearOnScrollListeners()
        news_list.addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        val subscription = newsManager.getNews(redditNews?.after ?: "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { retrievedNews ->
                            redditNews = retrievedNews
                            (news_list.adapter as NewsAdapter).addNews(retrievedNews.news)
                        }, { e ->
                    Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                })
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}



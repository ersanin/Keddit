@file:JvmName("ExtensionsUtils")

package com.example.ersanin.keddit.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ersanin.keddit.R
import com.example.ersanin.keddit.common.extensions.inflate
import com.example.ersanin.keddit.features.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*

/**
 * Created by Ersanin on 20.06.2016.
 */
class NewsFragment : Fragment() {

    private val newsList: RecyclerView by lazy {
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList.setHasFixedSize(true) // <-- Lazy executed!
        newsList.layoutManager = LinearLayoutManager(context)

        initAdapter()
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }

}



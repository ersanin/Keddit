package com.example.ersanin.keddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.ersanin.keddit.R
import com.example.ersanin.keddit.common.adapter.ViewType
import com.example.ersanin.keddit.common.adapter.ViewTypeDelegateAdapter
import com.example.ersanin.keddit.common.extensions.inflate

/**
 * Created by Ersanin on 20.06.2016.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}
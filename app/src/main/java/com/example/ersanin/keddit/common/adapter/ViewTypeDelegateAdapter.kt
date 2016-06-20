package com.example.ersanin.keddit.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Ersanin on 20.06.2016.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}